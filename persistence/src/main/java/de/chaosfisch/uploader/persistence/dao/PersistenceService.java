/*
 * Copyright (c) 2014 Dennis Fischer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0+
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors: Dennis Fischer
 */

package de.chaosfisch.uploader.persistence.dao;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.esotericsoftware.kryo.serializers.CompatibleFieldSerializer;
import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import de.chaosfisch.google.account.Account;
import de.chaosfisch.google.youtube.playlist.Playlist;
import de.chaosfisch.google.youtube.upload.Upload;
import de.chaosfisch.uploader.template.Template;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class PersistenceService implements IPersistenceService {
	private static final Pattern STORAGE_PATTERN = Pattern.compile("data-([0-9]+)\\.data");
	private static final Pattern BACKUP_PATTERN = Pattern.compile("(.*)\\.xml");
	private static final int ITERATIONS = 42;
	private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceService.class);

	private final IAccountDao accountDao;
	private final IPlaylistDao playlistDao;
	private final ITemplateDao templateDao;
	private final IUploadDao uploadDao;
	private final String storage;

	private final AtomicInteger version = new AtomicInteger();
	private Data data = new Data();
	private String masterPassword;
	private final Serializer<File> fileSerializer = new Serializer<File>() {
		@Override
		public void write(final Kryo kryo, final Output output, final File object) {
			output.writeString(null == object ? null : object.getAbsolutePath());
		}

		@Override
		public File read(final Kryo kryo, final Input input, final Class type) {
			final String path = input.readString();
			return null == path ? null : new File(path);
		}
	};

	private final Serializer<DateTime> dateTimeSerializer = new Serializer<DateTime>() {
		@Override
		public void write(final Kryo kryo, final Output output, final DateTime object) {
			output.writeLong(null == object ? 0 : object.getMillis());
		}

		@Override
		public DateTime read(final Kryo kryo, final Input input, final Class type) {
			final long milis = input.readLong();
			return 0 == milis ? null : new DateTime(milis);
		}
	};

	private final ThreadLocal<Kryo> kryo = new ThreadLocal<Kryo>() {
		@Override
		protected Kryo initialValue() {
			final Kryo kryo = new Kryo();
			kryo.setDefaultSerializer(CompatibleFieldSerializer.class);
			kryo.register(File.class, fileSerializer);
			kryo.register(DateTime.class, dateTimeSerializer);
			return kryo;
		}
	};

	//Arbitrarily selected 8-byte salt sequence:
	private static final byte[] salt = {(byte) 0x43, (byte) 0x76, (byte) 0x95, (byte) 0xc7, (byte) 0x5b, (byte) 0xd7,
			(byte) 0x45, (byte) 0x17};

	@Inject
	public PersistenceService(final IAccountDao accountDao, final IPlaylistDao playlistDao, final ITemplateDao templateDao, final IUploadDao uploadDao, @Named(PERSISTENCE_FOLDER) final String storage) {
		this.accountDao = accountDao;
		this.playlistDao = playlistDao;
		this.templateDao = templateDao;
		this.uploadDao = uploadDao;
		this.storage = storage;
		final Timer timer = new Timer(true);
		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				generateBackup();
			}
		}, TimeUnit.MINUTES.toMillis(10), TimeUnit.MINUTES.toMillis(10));
	}

	@Override
	public void saveToStorage() {
		final Data storageData = new Data();
		storageData.playlists = playlistDao.getPlaylists();
		storageData.accounts = accountDao.getAccounts();
		storageData.uploads = uploadDao.getUploads();
		storageData.templates = templateDao.getTemplates();

		final Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				final File storageFile = new File(storage + String.format("/data-%07d.data", version.incrementAndGet()));
				try (final Output output = new Output(new FileOutputStream(storageFile))) {

					if (null == masterPassword) {
						kryo.get().writeObject(output, storageData);
					} else {
						final Cipher cipher = makeCipher(masterPassword, false);
						kryo.get().writeObject(output, new SealedObject(storageData, cipher));
					}
				} catch (final Exception e) {
					LOGGER.error("Couldn't save data", e);
					storageFile.delete();
				}
			}
		}, "Persistence");
		thread.setDaemon(true);
		thread.start();
	}

	@Override
	public boolean loadFromStorage() {
		try {
			data = getData();
			generateBackup();
			loadPlaylists(data);
			loadAccounts(data);
			loadTemplates(data);
			loadUploads(data);
		} catch (final Exception e) {
			LOGGER.error("Data load error", e);

			LOGGER.info("Trying to use latest backup");
			final File backupFile = getNewestBackupFile();
			if (null != backupFile) {
				loadBackup(backupFile);
				return true;
			} else {
				LOGGER.warn("Backup not existing!");
			}
			return false;
		}

		return true;
	}

	private Data getData() throws Exception {
		final File storageFile = getStorageFile();
		if (null == storageFile) {
			return new Data();
		}

		final Data loadedData;

		try (final Input input = new Input(new FileInputStream(storageFile))) {
			if (null == masterPassword) {
				loadedData = kryo.get().readObject(input, Data.class);
			} else {
				final Cipher cipher = makeCipher(masterPassword, true);
				loadedData = (Data) kryo.get().readObject(input, SealedObject.class).getObject(cipher);
			}
			return loadedData;
		}
	}

	@Override
	public void cleanStorage() {
		getStorageFile(true);
	}

	private File getStorageFile() {
		return getStorageFile(false);
	}

	File getNewestBackupFile() {
		final File backupDir = new File(storage + "/backups/");
		if (!backupDir.isDirectory()) {
			return null;
		}
		final List<File> list = Arrays.asList(backupDir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(final File dir, final String name) {
				return BACKUP_PATTERN.matcher(name).matches(); // or something else
			}
		}));
		if (list.isEmpty()) {
			return null;
		}
		Collections.sort(list, new Comparator<File>() {
			@Override
			public int compare(final File o1, final File o2) {
				return o1.getAbsolutePath().compareToIgnoreCase(o2.getAbsolutePath());
			}
		});

		return list.get(list.size() - 1);
	}

	File getStorageFile(final boolean cleanup) {
		final File storageDir = new File(storage);
		if (!storageDir.isDirectory()) {
			return null;
		}
		final List<File> list = Arrays.asList(storageDir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(final File dir, final String name) {
				return STORAGE_PATTERN.matcher(name).matches(); // or something else
			}
		}));
		if (list.isEmpty()) {
			return null;
		}
		Collections.sort(list, new Comparator<File>() {
			@Override
			public int compare(final File o1, final File o2) {
				return o1.getAbsolutePath().compareToIgnoreCase(o2.getAbsolutePath());
			}
		});

		final File storageFile = list.get(list.size() - 1);
		final Matcher matcher = STORAGE_PATTERN.matcher(storageFile.getAbsolutePath());
		if (matcher.find()) {
			version.set(Integer.parseInt(matcher.group(1)));
		}

		if (cleanup) {
			for (final File file : list) {
				if (!file.equals(storageFile)) {
					file.delete();
				}
			}
		}

		return storageFile;
	}

	@Override
	public boolean loadBackup(final File file) {
		if (!file.exists()) {
			LOGGER.warn("Backup file not existing: {}", file.getAbsolutePath());
			return false;
		}
		try {
			final XStream xStream = new XStream(new DomDriver(Charsets.UTF_8.name()));
			final Data loadedData;
			if (null == masterPassword) {
				try (FileInputStream fileInputStream = new FileInputStream(file)) {
					loadedData = (Data) xStream.fromXML(fileInputStream);
				}
			} else {
				final Cipher cipher = makeCipher(masterPassword, true);

				try (FileInputStream fileInputStream = new FileInputStream(file);
					 CipherInputStream cis = new CipherInputStream(fileInputStream, cipher)) {
					loadedData = (Data) xStream.fromXML(cis);
				}
			}

			loadPlaylists(loadedData);
			loadAccounts(loadedData);
			loadTemplates(loadedData);
			loadUploads(loadedData);
			saveToStorage();
		} catch (final Exception e) {
			LOGGER.error("Couldn't load backup!", e);
			return false;
		}
		return true;
	}

	@Override
	public void setMasterPassword(final String masterPassword) {
		this.masterPassword = masterPassword;
	}

	@Override
	public void generateBackup() {
		final File backupFile = new File(storage + String.format("/backups/%s.xml", new SimpleDateFormat("dd-MM-yyyy HH-mm-ss")
				.format(new Date())));
		try {
			LOGGER.info("Creating backup {}", backupFile);
			Files.createParentDirs(backupFile);
			final XStream xStream = new XStream(new DomDriver(Charsets.UTF_8.name()));
			if (null == masterPassword) {
				try (FileOutputStream fileOutputStream = new FileOutputStream(backupFile)) {
					xStream.toXML(data, fileOutputStream);
				}
			} else {
				final Cipher cipher = makeCipher(masterPassword, false);

				try (FileOutputStream fileOutputStream = new FileOutputStream(backupFile);
					 CipherOutputStream cos = new CipherOutputStream(fileOutputStream, cipher)) {
					xStream.toXML(data, cos);
				}
			}
		} catch (final Exception e) {
			LOGGER.error("Couldn't create backup!", e);
		}
	}

	private Cipher makeCipher(final String pass, final boolean decryptMode) throws GeneralSecurityException {

		//Use a KeyFactory to derive the corresponding key from the passphrase:
		final PBEKeySpec keySpec = new PBEKeySpec(pass.toCharArray());
		final SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
		final SecretKey key = keyFactory.generateSecret(keySpec);

		//Create parameters from the salt and an arbitrary number of iterations:
		final PBEParameterSpec pbeParamSpec = new PBEParameterSpec(salt, ITERATIONS);

		//Set up the cipher:
		final Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");

		//Set the cipher mode to decryption or encryption:
		if (decryptMode) {
			cipher.init(Cipher.DECRYPT_MODE, key, pbeParamSpec);
		} else {
			cipher.init(Cipher.ENCRYPT_MODE, key, pbeParamSpec);
		}

		return cipher;
	}

	private void loadUploads(final Data data) {
		final List<Upload> uploads = data.uploads;

		for (final Upload upload : uploads) {
			if (null != upload.getAccount()) {
				if (accountDao.getAccounts().contains(upload.getAccount())) {
					upload.setAccount(accountDao.getAccounts()
							.get(accountDao.getAccounts().indexOf(upload.getAccount())));
				} else {
					upload.setAccount(null);
				}
			}
			for (final Playlist playlist : data.playlists) {
				if (upload.getPlaylists().contains(playlist)) {
					upload.getPlaylists().remove(playlist);
					upload.getPlaylists().add(playlist);
				}
			}
		}
		uploadDao.setUploads(uploads);
	}

	private void loadTemplates(final Data data) {
		final List<Template> templates = data.templates;
		for (final Template template : templates) {
			if (null != template.getAccount()) {
				if (accountDao.getAccounts().contains(template.getAccount())) {
					template.setAccount(accountDao.getAccounts()
							.get(accountDao.getAccounts().indexOf(template.getAccount())));
				} else {
					template.setAccount(null);
				}
			}
			for (final Playlist playlist : data.playlists) {
				if (template.getPlaylists().contains(playlist)) {
					template.getPlaylists().remove(playlist);
					template.getPlaylists().add(playlist);
				}
			}
		}
		templateDao.setTemplates(templates);
	}

	private void loadAccounts(final Data data) {
		final List<Account> accounts = data.accounts;
		for (final Account account : accounts) {
			for (final Playlist playlist : playlistDao.getPlaylists()) {
				if (account.getPlaylists().contains(playlist)) {
					account.getPlaylists().remove(playlist);
					account.getPlaylists().add(playlist);
				}
			}
		}
		accountDao.setAccounts(accounts);
	}

	private void loadPlaylists(final Data data) {
		playlistDao.setPlaylists(data.playlists);
	}
}
