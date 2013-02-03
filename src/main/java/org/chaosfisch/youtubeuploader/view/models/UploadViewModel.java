/*******************************************************************************
 * Copyright (c) 2013 Dennis Fischer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0+
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: Dennis Fischer
 ******************************************************************************/
package org.chaosfisch.youtubeuploader.view.models;

import java.io.File;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.control.SingleSelectionModel;
import javafx.util.converter.DefaultStringConverter;

import org.chaosfisch.google.atom.AtomCategory;
import org.chaosfisch.util.EventBusUtil;
import org.chaosfisch.util.ExtendedPlaceholders;
import org.chaosfisch.util.ThreadUtil;
import org.chaosfisch.youtubeuploader.I18nHelper;
import org.chaosfisch.youtubeuploader.controller.ViewController;
import org.chaosfisch.youtubeuploader.models.Account;
import org.chaosfisch.youtubeuploader.models.Playlist;
import org.chaosfisch.youtubeuploader.models.Template;
import org.chaosfisch.youtubeuploader.models.Upload;
import org.chaosfisch.youtubeuploader.models.UploadBuilder;
import org.chaosfisch.youtubeuploader.models.events.ModelPostRemovedEvent;
import org.chaosfisch.youtubeuploader.models.events.ModelPostSavedEvent;
import org.chaosfisch.youtubeuploader.services.youtube.spi.PlaylistService;
import org.javalite.activejdbc.Model;

import com.google.common.eventbus.Subscribe;
import com.google.inject.Inject;

public class UploadViewModel {

	// {{ UploadOptions
	public final SimpleListProperty<Model>							accountProperty					= new SimpleListProperty<>(
																											FXCollections
																													.<Model> observableArrayList());
	public final SimpleListProperty<Model>							templateProperty				= new SimpleListProperty<>(
																											FXCollections
																													.<Model> observableArrayList());
	public final SimpleListProperty<Model>							playlistDropListProperty		= new SimpleListProperty<>(
																											FXCollections
																													.<Model> observableArrayList());
	public final SimpleListProperty<Model>							playlistSourceListProperty		= new SimpleListProperty<>(
																											FXCollections
																													.<Model> observableArrayList());
	public final SimpleListProperty<AtomCategory>					categoryProperty				= new SimpleListProperty<>(
																											FXCollections
																													.<AtomCategory> observableArrayList());
	public final SimpleListProperty<String>							commentProperty					= new SimpleListProperty<>(
																											FXCollections
																													.<String> observableArrayList());
	public final SimpleListProperty<File>							fileProperty					= new SimpleListProperty<>(
																											FXCollections
																													.<File> observableArrayList());
	public final SimpleListProperty<String>							licenseProperty					= new SimpleListProperty<>(
																											FXCollections
																													.<String> observableArrayList());
	public final SimpleListProperty<String>							videoresponseProperty			= new SimpleListProperty<>(
																											FXCollections
																													.<String> observableArrayList());
	public final SimpleListProperty<String>							visibilityProperty				= new SimpleListProperty<>(
																											FXCollections
																													.<String> observableArrayList());
	public final SimpleStringProperty								previewTitleProperty			= new SimpleStringProperty();
	public final SimpleBooleanProperty								commentVoteProperty				= new SimpleBooleanProperty();
	public final SimpleStringProperty								defaultdirProperty				= new SimpleStringProperty();
	public final SimpleStringProperty								descriptionProperty				= new SimpleStringProperty();
	public final SimpleBooleanProperty								embedProperty					= new SimpleBooleanProperty();
	public final SimpleStringProperty								enddirProperty					= new SimpleStringProperty();
	public final SimpleBooleanProperty								mobileProperty					= new SimpleBooleanProperty();
	public final SimpleBooleanProperty								rateProperty					= new SimpleBooleanProperty();
	public final SimpleStringProperty								tagsProperty					= new SimpleStringProperty();
	public final SimpleStringProperty								titleProperty					= new SimpleStringProperty();
	public final SimpleBooleanProperty								facebookProperty				= new SimpleBooleanProperty();
	public final SimpleBooleanProperty								twitterProperty					= new SimpleBooleanProperty();
	public final SimpleStringProperty								messageProperty					= new SimpleStringProperty();

	public final SimpleObjectProperty<Calendar>						starttimeProperty				= new SimpleObjectProperty<>(
																											Calendar.getInstance());
	public final SimpleObjectProperty<Calendar>						releasetimeProperty				= new SimpleObjectProperty<>(
																											Calendar.getInstance());
	public final SimpleIntegerProperty								numberProperty					= new SimpleIntegerProperty();
	public final SimpleObjectProperty<File>							initialDirectoryProperty		= new SimpleObjectProperty<>();
	public final SimpleStringProperty								thumbnailProperty				= new SimpleStringProperty();
	public final SimpleIntegerProperty								idProperty						= new SimpleIntegerProperty(-1);

	public SimpleObjectProperty<SingleSelectionModel<AtomCategory>>	selectedCategoryProperty;
	public SimpleObjectProperty<SingleSelectionModel<File>>			selectedFileProperty;
	public SimpleObjectProperty<SingleSelectionModel<Model>>		selectedAccountProperty;
	public SimpleObjectProperty<SingleSelectionModel<String>>		selectedCommentProperty;
	public SimpleObjectProperty<SingleSelectionModel<String>>		selectedLicenseProperty;
	public SimpleObjectProperty<SingleSelectionModel<String>>		selectedVideoResponseProperty;
	public SimpleObjectProperty<SingleSelectionModel<String>>		selectedVisibilityProperty;
	public SimpleObjectProperty<SingleSelectionModel<Model>>		selectedTemplateProperty;
	// }} UploadOptions
	// {{ MonetizeOptions
	public SimpleBooleanProperty									claimProperty					= new SimpleBooleanProperty();
	public SimpleBooleanProperty									overlayProperty					= new SimpleBooleanProperty();
	public SimpleBooleanProperty									trueViewProperty				= new SimpleBooleanProperty();
	public SimpleBooleanProperty									inStreamProperty				= new SimpleBooleanProperty();
	public SimpleBooleanProperty									inStreamDefaultsProperty		= new SimpleBooleanProperty();
	public SimpleBooleanProperty									productPlacementProperty		= new SimpleBooleanProperty();

	public SimpleListProperty<String>								claimTypeProperty				= new SimpleListProperty<>(
																											FXCollections
																													.<String> observableArrayList());
	public SimpleListProperty<String>								claimOptionsProperty			= new SimpleListProperty<>(
																											FXCollections
																													.<String> observableArrayList());

	public SimpleStringProperty										tmsidProperty					= new SimpleStringProperty();
	public SimpleStringProperty										isanProperty					= new SimpleStringProperty();
	public SimpleStringProperty										eidrProperty					= new SimpleStringProperty();
	public SimpleStringProperty										customidProperty				= new SimpleStringProperty();
	public SimpleStringProperty										numberSeasonProperty			= new SimpleStringProperty();
	public SimpleStringProperty										numberEpisodeProperty			= new SimpleStringProperty();
	public SimpleStringProperty										monetizeTitleEpisodeProperty	= new SimpleStringProperty();
	public SimpleStringProperty										monetizeTitleProperty			= new SimpleStringProperty();
	public SimpleStringProperty										monetizeNotesProperty			= new SimpleStringProperty();
	public SimpleStringProperty										monetizeDescriptionProperty		= new SimpleStringProperty();
	// }} MonetizeOptions

	@Inject private PlaylistService									playlistService;

	public UploadViewModel() {
		EventBusUtil.getInstance().register(this);
	}

	@SuppressWarnings("unchecked")
	public void init(final SingleSelectionModel<AtomCategory> categorySelectionModel, final SingleSelectionModel<File> fileSelectionModel,
			final SingleSelectionModel<Model> accountSelectionModel, final SingleSelectionModel<String> commentSelectionModel,
			final SingleSelectionModel<String> licenseSelectionModel, final SingleSelectionModel<String> videoresponseSelectionModel,
			final SingleSelectionModel<String> visibilitySelectionModel, final SingleSelectionModel<Model> templateSelectionModel) {
		selectedCategoryProperty = new SimpleObjectProperty<>(categorySelectionModel);
		selectedFileProperty = new SimpleObjectProperty<>(fileSelectionModel);
		selectedAccountProperty = new SimpleObjectProperty<>(accountSelectionModel);
		selectedCommentProperty = new SimpleObjectProperty<>(commentSelectionModel);
		selectedLicenseProperty = new SimpleObjectProperty<>(licenseSelectionModel);
		selectedVideoResponseProperty = new SimpleObjectProperty<>(videoresponseSelectionModel);
		selectedVisibilityProperty = new SimpleObjectProperty<>(visibilitySelectionModel);
		selectedTemplateProperty = new SimpleObjectProperty<>(templateSelectionModel);

		visibilityProperty.addAll(I18nHelper.message("visibilitylist.public"), I18nHelper.message("visibilitylist.unlisted"),
				I18nHelper.message("visibilitylist.private"), I18nHelper.message("visibilitylist.scheduled"));

		commentProperty.addAll(I18nHelper.message("commentlist.allowed"), I18nHelper.message("commentlist.moderated"),
				I18nHelper.message("commentlist.denied"), I18nHelper.message("commentlist.friendsonly"));
		licenseProperty.addAll(I18nHelper.message("licenselist.youtube"), I18nHelper.message("licenselist.cc"));
		videoresponseProperty.addAll(I18nHelper.message("videoresponselist.allowed"), I18nHelper.message("videoresponselist.moderated"),
				I18nHelper.message("videoresponselist.denied"));

		claimTypeProperty.addAll(I18nHelper.message("claimtype.visual"), I18nHelper.message("claimtype.audiovisual"),
				I18nHelper.message("claimtype.audio"));
		claimOptionsProperty.addAll(I18nHelper.message("claimoptions.monetize"), I18nHelper.message("claimoptions.track"),
				I18nHelper.message("claimoptions.block"));

		accountProperty.addAll(Account.where("type = ?", Account.Type.YOUTUBE.name()).include(Playlist.class));
		templateProperty.addAll(Template.findAll().include(Account.class, Playlist.class));

		final InvalidationListener previewTitleChangeListener = new InvalidationListener() {

			@Override
			public void invalidated(final Observable observable) {
				final String value = titleProperty.get();
				titleProperty.set("");
				titleProperty.set(value);
			}
		};
		numberProperty.addListener(previewTitleChangeListener);
		selectedFileProperty.addListener(previewTitleChangeListener);
		previewTitleProperty.bindBidirectional(titleProperty, new DefaultStringConverter() {

			final ExtendedPlaceholders	extendedPlaceholders	= new ExtendedPlaceholders();

			@Override
			public String toString(final String value) {
				extendedPlaceholders.setFile(selectedFileProperty.get().getSelectedItem() != null ? selectedFileProperty.get()
						.getSelectedItem().getAbsolutePath() : "{file-missing}");
				extendedPlaceholders.setNumber(numberProperty.get());

				return extendedPlaceholders.replace(value);
			}
		});

		selectedTemplateProperty.get().selectedItemProperty().addListener(new InvalidationListener() {

			@Override
			public void invalidated(final Observable arg0) {
				resetTemplate();
			}
		});

		selectedAccountProperty.get().selectedItemProperty().addListener(new ChangeListener<Model>() {

			@Override
			public void changed(final ObservableValue<? extends Model> observable, final Model oldValue, final Model newValue) {
				if (newValue != null && newValue.getAll(Playlist.class) != null) {
					playlistSourceListProperty.clear();
					playlistSourceListProperty.addAll(newValue.getAll(Playlist.class));
				}
			}
		});
	}

	public void resetTemplate() {
		_reset((Template) (selectedTemplateProperty.get().getSelectedItem() == null ? ViewController.standardTemplate
				: selectedTemplateProperty.get().getSelectedItem()));
	}

	private void _reset(final Template template) {
		if (!categoryProperty.isEmpty()) {
			selectedCategoryProperty.get().select(template.getInteger("category") != null ? template.getInteger("category") : 0);
		}
		selectedCommentProperty.get().select(template.getInteger("comment") != null ? template.getInteger("comment") : 0);
		commentVoteProperty.set(template.getBoolean("commentvote"));
		defaultdirProperty.set(template.getString("defaultdir"));
		descriptionProperty.set(template.getString("description"));
		embedProperty.set(template.getBoolean("embed"));
		enddirProperty.set(template.getString("enddir"));
		selectedLicenseProperty.get().select(template.getInteger("license") != null ? template.getInteger("license") : 0);
		mobileProperty.set(template.getBoolean("mobile"));
		rateProperty.set(template.getBoolean("rate"));
		tagsProperty.set(template.getString("keywords"));
		titleProperty.set(template.getString("title"));
		selectedVideoResponseProperty.get().select(template.getInteger("videoresponse") != null ? template.getInteger("videoresponse") : 1);
		selectedVisibilityProperty.get().select(template.getInteger("visibility") != null ? template.getInteger("visibility") : 0);
		numberProperty.set(template.getInteger("number") != null ? template.getInteger("number") : 0);
		thumbnailProperty.set(template.getString("thumbnail") != null ? template.getString("thumbnail") : "");
		facebookProperty.set(template.getBoolean("facebook"));
		twitterProperty.set(template.getBoolean("twitter"));
		messageProperty.set(template.getString("message") != null ? template.getString("message") : "");

		if (template.parent(Account.class) != null) {
			selectedAccountProperty.get().select(template.parent(Account.class));
		}

		final Iterator<Model> playlistDropListIterator = playlistDropListProperty.get().iterator();
		while (playlistDropListIterator.hasNext()) {
			final Model playlist = playlistDropListIterator.next();
			playlistSourceListProperty.add(playlist);
			playlistDropListIterator.remove();
		}

		final Iterator<Playlist> playlistSourceListIterator = template.getAll(Playlist.class).iterator();
		while (playlistSourceListIterator.hasNext()) {
			final Playlist playlist = playlistSourceListIterator.next();
			playlistDropListProperty.add(playlist);
			playlistSourceListProperty.remove(playlist);
		}

		final File defaultDir = new File(template.getString("defaultdir") != null ? template.getString("defaultdir") : "");
		if (defaultDir.exists() && defaultDir.isDirectory()) {
			initialDirectoryProperty.set(defaultDir);
		}

		releasetimeProperty.set(Calendar.getInstance());
		starttimeProperty.set(Calendar.getInstance());
		thumbnailProperty.set("");
		idProperty.setValue(-1);
	}

	public Upload toUpload() {
		final UploadBuilder uploadBuilder = new UploadBuilder(selectedFileProperty.get().getSelectedItem(), titleProperty.get(),
				selectedCategoryProperty.get().getSelectedItem().term, (Account) selectedAccountProperty.get().getSelectedItem())
				.setComment(selectedCommentProperty.get().getSelectedIndex()).setCommentvote(commentVoteProperty.get())
				.setDescription(descriptionProperty.get() == null ? "" : descriptionProperty.get()).setEmbed(embedProperty.get())
				.setEnddir(enddirProperty.get()).setLicense(selectedLicenseProperty.get().getSelectedIndex())
				.setMobile(mobileProperty.get()).setNumber(numberProperty.get()).setRate(rateProperty.get())
				.setTags(tagsProperty.get() == null ? "" : tagsProperty.get())
				.setVideoresponse(selectedVideoResponseProperty.get().getSelectedIndex())
				.setVisibility(selectedVisibilityProperty.get().getSelectedIndex()).setThumbnail(thumbnailProperty.get());
		if (idProperty.get() != -1) {
			uploadBuilder.setId(idProperty.get());
		}

		for (final Model playlist : playlistDropListProperty.get()) {
			uploadBuilder.addPlaylist((Playlist) playlist);
		}

		if (starttimeProperty.get().getTimeInMillis() > System.currentTimeMillis()) {
			uploadBuilder.setStarted(starttimeProperty.get().getTime());
		}

		if (releasetimeProperty.get().getTimeInMillis() > System.currentTimeMillis()) {
			final Calendar calendar = new GregorianCalendar();
			calendar.setTime(releasetimeProperty.get().getTime());
			final int unroundedMinutes = calendar.get(Calendar.MINUTE);
			final int mod = unroundedMinutes % 30;
			calendar.add(Calendar.MINUTE, mod < 16 ? -mod : 30 - mod);
			uploadBuilder.setRelease(calendar.getTime());

			if ((facebookProperty.get() || twitterProperty.get()) && messageProperty.get() != null && !messageProperty.get().isEmpty()) {
				uploadBuilder.setFacebook(facebookProperty.get()).setTwitter(twitterProperty.get()).setMessage(messageProperty.get());
			}
		}

		final Upload upload = uploadBuilder.build();
		if (upload.isValid()) {
			fileProperty.remove(selectedFileProperty.get().getSelectedItem());
			selectedFileProperty.get().selectNext();
			upload.save();
			idProperty.setValue(-1);
			uploadBuilder.finalize(upload);
		}
		return upload;
	}

	public void fromUpload(final Upload upload) {
		final File file = new File(upload.getString("file"));
		idProperty.set(upload.getInteger("id"));
		if (!fileProperty.contains(file)) {
			fileProperty.add(file);
		}
		selectedFileProperty.get().select(file);
		selectedAccountProperty.get().select(upload.parent(Account.class));
		selectedCommentProperty.get().select(upload.getInteger("comment"));
		selectedLicenseProperty.get().select(upload.getString("license"));
		selectedVideoResponseProperty.get().select(upload.getInteger("videoresponse"));
		selectedVisibilityProperty.get().select(upload.getInteger("visibility"));
		commentVoteProperty.set(upload.getBoolean("commentvote"));
		descriptionProperty.set(upload.getString("description") != null ? upload.getString("description") : "");
		embedProperty.set(upload.getBoolean("embed"));
		enddirProperty.set(upload.getString("enddir") != null ? upload.getString("enddir") : "");
		mobileProperty.set(upload.getBoolean("mobile"));
		numberProperty.set(upload.getInteger("number"));
		rateProperty.set(upload.getBoolean("rate"));
		tagsProperty.set(upload.getString("keywords") != null ? upload.getString("keywords") : "");
		titleProperty.set(upload.getString("title") != null ? upload.getString("title") : "");
		thumbnailProperty.set(upload.getString("thumbnail") != null ? upload.getString("thumbnail") : "");
		twitterProperty.set(upload.getBoolean("twitter"));
		facebookProperty.set(upload.getBoolean("facebook"));
		messageProperty.set(upload.getString("message") != null ? upload.getString("message") : "");
		Calendar calendar = Calendar.getInstance();
		if (upload.getDate("started") != null) {
			calendar.setTime(upload.getDate("started"));
		}
		starttimeProperty.set(calendar);
		calendar = Calendar.getInstance();
		if (upload.getDate("release") != null) {
			calendar.setTime(upload.getDate("release"));
		}
		releasetimeProperty.set(calendar);

		for (final AtomCategory category : categoryProperty) {
			if (category.term.equals(upload.getString("category"))) {
				selectedCategoryProperty.get().select(category);
			}
		}

		final Iterator<Model> playlistDropListIterator = playlistDropListProperty.get().iterator();
		while (playlistDropListIterator.hasNext()) {
			final Model playlist = playlistDropListIterator.next();
			playlistSourceListProperty.add(playlist);
			playlistDropListIterator.remove();
		}

		final Iterator<Playlist> playlistSourceListIterator = upload.getAll(Playlist.class).iterator();
		while (playlistSourceListIterator.hasNext()) {
			final Playlist playlist = playlistSourceListIterator.next();
			playlistDropListProperty.add(playlist);
			playlistSourceListProperty.remove(playlist);
		}
	}

	public void saveTemplate() {
		final Template template = (Template) selectedTemplateProperty.get().getSelectedItem();

		if (template == null) {
			return;
		}
		template.setInteger("category", selectedCategoryProperty.get().getSelectedIndex());
		template.setInteger("comment", selectedCommentProperty.get().getSelectedIndex());
		template.setBoolean("commentvote", commentVoteProperty.get());
		template.setString("defaultdir", defaultdirProperty.get() == null ? "" : defaultdirProperty.get());
		template.setString("description", descriptionProperty.get() == null ? "" : descriptionProperty.get());
		template.setBoolean("embed", embedProperty.get());
		template.setString("enddir", enddirProperty.get() == null ? "" : enddirProperty.get());
		template.setInteger("license", selectedLicenseProperty.get().getSelectedIndex());
		template.setBoolean("mobile", mobileProperty.get());
		template.setBoolean("rate", rateProperty.get());
		template.setString("keywords", tagsProperty.get() == null ? "" : tagsProperty.get());
		template.setString("title", titleProperty.get() == null ? "" : titleProperty.get());
		template.setInteger("videoresponse", selectedVideoResponseProperty.get().getSelectedIndex());
		template.setInteger("visibility", selectedVisibilityProperty.get().getSelectedIndex());
		template.setInteger("number", numberProperty.get());
		if (selectedAccountProperty.get() != null) {
			template.setParent(selectedAccountProperty.get().getSelectedItem());
		}

		for (final Playlist playlist : template.getAll(Playlist.class)) {
			template.remove(playlist);
		}
		for (final Model playlist : playlistDropListProperty.get()) {
			template.add(playlist);
		}
		template.saveIt();

	}

	public void movePlaylistToDropzone(final int model) {
		if (model >= 0) {
			playlistDropListProperty.add(playlistSourceListProperty.get(model));
			playlistSourceListProperty.remove(model);
		}
	}

	public void removePlaylistFromDropzone(final int model) {
		if (model >= 0) {
			playlistSourceListProperty.add(playlistDropListProperty.get(model));
			playlistDropListProperty.remove(model);
		}
	}

	public void removeTemplate() {
		if (selectedTemplateProperty.get() != null) {
			selectedTemplateProperty.get().getSelectedItem().delete();
		}
	}

	@Subscribe
	public void onModelAdded(final ModelPostSavedEvent modelPostSavedEvent) {
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				if (modelPostSavedEvent.getModel() instanceof Account
						&& modelPostSavedEvent.getModel().get("type").equals(Account.Type.YOUTUBE.name())) {
					if (accountProperty.contains(modelPostSavedEvent.getModel())) {
						accountProperty.set(accountProperty.indexOf(modelPostSavedEvent.getModel()), modelPostSavedEvent.getModel());
					} else {
						accountProperty.add(modelPostSavedEvent.getModel());
						if (selectedAccountProperty.get().getSelectedItem() == null && accountProperty.size() > 0) {
							selectedAccountProperty.get().select(accountProperty.get(0));
						}
					}
				} else if (modelPostSavedEvent.getModel() instanceof Template) {
					if (templateProperty.contains(modelPostSavedEvent.getModel())) {
						templateProperty.set(templateProperty.indexOf(modelPostSavedEvent.getModel()), modelPostSavedEvent.getModel());
						selectedTemplateProperty.get().select(modelPostSavedEvent.getModel());
					} else {
						templateProperty.add(modelPostSavedEvent.getModel());
						if (selectedTemplateProperty.get().getSelectedItem() == null && templateProperty.size() > 0) {
							selectedTemplateProperty.get().select(templateProperty.get(0));
						}
					}
				} else if (modelPostSavedEvent.getModel() instanceof Playlist
						&& modelPostSavedEvent.getModel().parent(Account.class).equals(selectedAccountProperty.get().getSelectedItem())) {
					if (playlistSourceListProperty.contains(modelPostSavedEvent.getModel())) {
						playlistSourceListProperty.set(playlistSourceListProperty.indexOf(modelPostSavedEvent.getModel()),
								modelPostSavedEvent.getModel());
					} else if (playlistDropListProperty.contains(modelPostSavedEvent.getModel())) {
						playlistDropListProperty.set(playlistDropListProperty.indexOf(modelPostSavedEvent.getModel()),
								modelPostSavedEvent.getModel());
					} else {
						playlistSourceListProperty.add(modelPostSavedEvent.getModel());
					}
				}
			}
		});
	}

	@Subscribe
	public void onModelRemoved(final ModelPostRemovedEvent modelPostRemovedEvent) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if (modelPostRemovedEvent.getModel() instanceof Account) {
					accountProperty.remove(modelPostRemovedEvent.getModel());
					if (selectedAccountProperty.get().getSelectedItem() == null && accountProperty.size() > 0) {
						selectedAccountProperty.get().select(accountProperty.get(0));
					}
				} else if (modelPostRemovedEvent.getModel() instanceof Template) {
					templateProperty.remove(modelPostRemovedEvent.getModel());
					if (selectedTemplateProperty.get().getSelectedItem() == null && templateProperty.size() > 0) {
						selectedTemplateProperty.get().select(templateProperty.get(0));
					}
				} else if (modelPostRemovedEvent.getModel() instanceof Playlist) {
					playlistSourceListProperty.remove(modelPostRemovedEvent.getModel());
					playlistDropListProperty.remove(modelPostRemovedEvent.getModel());
				}
			}
		});

	}

	public void refreshPlaylists() {
		final Account[] accountArray = new Account[accountProperty.size()];
		accountProperty.toArray(accountArray);
		ThreadUtil.doInBackground(new Runnable() {

			@Override
			public void run() {
				playlistService.synchronizePlaylists(Arrays.asList(accountArray));
			}
		});
	}
}
