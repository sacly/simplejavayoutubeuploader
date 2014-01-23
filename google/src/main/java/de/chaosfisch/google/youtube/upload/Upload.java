/*
 * Copyright (c) 2013 Dennis Fischer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0+
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors: Dennis Fischer
 */

/**
 * This class is generated by jOOQ
 */
package de.chaosfisch.google.youtube.upload;

import de.chaosfisch.google.account.Account;
import de.chaosfisch.google.youtube.playlist.Playlist;
import de.chaosfisch.google.youtube.upload.metadata.Metadata;
import de.chaosfisch.google.youtube.upload.metadata.Monetization;
import de.chaosfisch.google.youtube.upload.metadata.Social;
import de.chaosfisch.google.youtube.upload.metadata.permissions.Permissions;

import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Upload {

	@Deprecated
	private transient Calendar dateOfStart;
	@Deprecated
	private transient Calendar dateOfRelease;

	private final CopyOnWriteArrayList<Playlist> playlists = new CopyOnWriteArrayList<>();
	private Social social = new Social();
	private Status status = new Status();
	private Monetization monetization = new Monetization();
	private Permissions permissions = new Permissions();
	private Metadata metadata = new Metadata();
	private String mimetype = "application/octet-stream";

	private String id;
	private File file;
	private String uploadurl;
	private LocalDateTime dateTimeOfStart;
	private int order;
	private LocalDateTime dateTimeOfRelease;
	private boolean pauseOnFinish;
	private String videoid;
	private File enddir;
	private File thumbnail;

	private Account account;

	public int getOrder() {
		return order;
	}

	public void setOrder(final int order) {
		this.order = order;
	}

	public interface Validation {
		int MAX_THUMBNAIL_SIZE = 2097152;
		int MAX_TITLE_SIZE = 100;
		int MAX_DESCRIPTION_SIZE = 5000;

		String ACCOUNT = "accountNull";
		String FILE = "fileNullNotExisting";
		String ENDDIR = "enddirNotExisting";
		String THUMBNAIL = "thumbnailNotExsiting";
		String THUMBNAIL_SIZE = "thumbnailSize";
		String TITLE = "titleNull";
		String TITLE_SIZE = "titleSize";
		String TITLE_CHARACTERS = "titleCharacters";
		String CATEGORY = "categoryNull";
		String DESCRIPTION_SIZE = "descriptionNull";
		String DESCRIPTION_CHARACTERS = "descriptionCharacters";
		String KEYWORD = "keywordIllegal";
	}

	public Upload() {
	}

	public Upload(final Account account, final File file) {
		if (null == account) {
			throw new IllegalArgumentException(Validation.ACCOUNT);
		}
		this.account = account;
		setFile(file);
	}

	public String getId() {
		return id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public File getFile() {
		return file;
	}

	public void setFile(final File file) {
		if (null == file || !file.exists()) {
			throw new IllegalArgumentException(Validation.FILE);
		}
		this.file = file;
	}

	public String getMimetype() {
		return mimetype;
	}

	public void setMimetype(final String mimetype) {
		this.mimetype = mimetype;
	}

	public String getUploadurl() {
		return uploadurl;
	}

	public void setUploadurl(final String uploadurl) {
		this.uploadurl = uploadurl;
	}

	public LocalDateTime getDateTimeOfStart() {
		return dateTimeOfStart;
	}

	public void setDateTimeOfStart(final LocalDateTime dateTimeOfStart) {
		if (null == dateTimeOfStart || dateTimeOfStart.isBefore(LocalDateTime.now())) {
			this.dateTimeOfStart = null;
		} else {
			this.dateTimeOfStart = dateTimeOfStart;
		}
	}

	public LocalDateTime getDateTimeOfRelease() {
		return dateTimeOfRelease;
	}

	@SuppressWarnings("MagicNumber")
	public void setDateTimeOfRelease(final LocalDateTime dateTimeOfRelease) {
		if (null == dateTimeOfRelease || dateTimeOfRelease.isBefore(LocalDateTime.now())) {
			this.dateTimeOfRelease = null;
		} else {
			final int mod = dateTimeOfRelease.getMinute() % 30;
			dateTimeOfRelease.plusMinutes(16 > mod ? -mod : 30 - mod)
					.getMinute();
			this.dateTimeOfRelease = dateTimeOfRelease;
		}
	}

	public boolean isPauseOnFinish() {
		return pauseOnFinish;
	}

	public void setPauseOnFinish(final boolean pauseOnFinish) {
		this.pauseOnFinish = pauseOnFinish;
	}

	public String getVideoid() {
		return videoid;
	}

	public void setVideoid(final String videoid) {
		this.videoid = videoid;
	}

	public File getEnddir() {
		return enddir;
	}

	public void setEnddir(final File enddir) {
		if (null != enddir && !enddir.exists()) {
			throw new IllegalArgumentException(Validation.ENDDIR);
		}
		this.enddir = enddir;
	}

	public File getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(final File thumbnail) {
		if (null != thumbnail) {
			if (!thumbnail.exists()) {
				throw new IllegalArgumentException(Validation.THUMBNAIL);
			} else if (Validation.MAX_THUMBNAIL_SIZE < thumbnail.length()) {
				throw new IllegalArgumentException(Validation.THUMBNAIL_SIZE);
			}
		}
		this.thumbnail = thumbnail;
	}

	public Social getSocial() {
		return social;
	}

	public void setSocial(final Social social) {
		this.social = social;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(final Status status) {
		this.status = status;
	}

	public Monetization getMonetization() {
		return monetization;
	}

	public void setMonetization(final Monetization monetization) {
		this.monetization = monetization;
	}

	public Permissions getPermissions() {
		return permissions;
	}

	public void setPermissions(final Permissions permissions) {
		this.permissions = permissions;
	}

	public Metadata getMetadata() {
		return metadata;
	}

	public void setMetadata(final Metadata metadata) {
		this.metadata = metadata;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(final Account account) {
		this.account = account;
	}

	public List<Playlist> getPlaylists() {
		return new ArrayList<>(playlists);
	}

	public void setPlaylists(final List<Playlist> playlists) {
		this.playlists.clear();
		this.playlists.addAll(playlists);
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Upload)) {
			return false;
		}

		final Upload upload = (Upload) obj;

		return !(null != id ? !id.equals(upload.id) : null != upload.id);
	}

	@Override
	public int hashCode() {
		return null != id ? id.hashCode() : 0;
	}
}
