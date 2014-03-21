/**************************************************************************************************
 * Copyright (c) 2014 Dennis Fischer.                                                             *
 * All rights reserved. This program and the accompanying materials                               *
 * are made available under the terms of the GNU Public License v3.0+                             *
 * which accompanies this distribution, and is available at                                       *
 * http://www.gnu.org/licenses/gpl.html                                                           *
 *                                                                                                *
 * Contributors: Dennis Fischer                                                                   *
 **************************************************************************************************/

/**
 * This class is generated by jOOQ
 */
package de.chaosfisch.youtube.upload;

import de.chaosfisch.data.account.cookies.CookieDTO;
import de.chaosfisch.youtube.account.AccountModel;
import de.chaosfisch.youtube.playlist.PlaylistModel;
import de.chaosfisch.youtube.upload.metadata.License;
import de.chaosfisch.youtube.upload.metadata.Metadata;
import de.chaosfisch.youtube.upload.metadata.Monetization;
import de.chaosfisch.youtube.upload.metadata.Social;
import de.chaosfisch.youtube.upload.permissions.*;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;

import java.io.File;
import java.time.LocalDateTime;

public class UploadModel {

	private final SimpleStringProperty                id                = new SimpleStringProperty();
	private final SimpleListProperty<PlaylistModel>   playlists         = new SimpleListProperty<>(FXCollections.observableArrayList());
	private final SimpleObjectProperty<Social>        social            = new SimpleObjectProperty<>(new Social());
	private final SimpleObjectProperty<Status>        status            = new SimpleObjectProperty<>(Status.WAITING);
	private final SimpleObjectProperty<Monetization>  monetization      = new SimpleObjectProperty<>(new Monetization());
	private final SimpleObjectProperty<Permissions>   permissions       = new SimpleObjectProperty<>(new Permissions());
	private final SimpleObjectProperty<Metadata>      metadata          = new SimpleObjectProperty<>(new Metadata());
	private final SimpleStringProperty                uploadurl         = new SimpleStringProperty();
	private final SimpleStringProperty                videoid           = new SimpleStringProperty();
	private final SimpleObjectProperty<File>          file              = new SimpleObjectProperty<>();
	private final SimpleObjectProperty<File>          enddir            = new SimpleObjectProperty<>();
	private final SimpleObjectProperty<File>          thumbnail         = new SimpleObjectProperty<>();
	private final SimpleObjectProperty<LocalDateTime> dateTimeOfStart   = new SimpleObjectProperty<>();
	private final SimpleObjectProperty<LocalDateTime> dateTimeOfRelease = new SimpleObjectProperty<>();
	private final SimpleObjectProperty<LocalDateTime> dateTimeOfEnd     = new SimpleObjectProperty<>();
	private final SimpleIntegerProperty               order             = new SimpleIntegerProperty();
	private final SimpleObjectProperty<AccountModel>  account           = new SimpleObjectProperty<>();
	private final SimpleDoubleProperty                progress          = new SimpleDoubleProperty();
	private final SimpleBooleanProperty               stopAfter         = new SimpleBooleanProperty();
	private final SimpleLongProperty                  fileSize          = new SimpleLongProperty();

	public long getFileSize() {
		return fileSize.get();
	}

	public void setFileSize(final long fileSize) {
		this.fileSize.set(fileSize);
	}

	public SimpleLongProperty fileSizeProperty() {
		return fileSize;
	}

	public double getProgress() {
		return progress.get();
	}

	public void setProgress(final double progress) {
		this.progress.set(progress);
	}

	public SimpleDoubleProperty progressProperty() {
		return progress;
	}

	public LocalDateTime getDateTimeOfEnd() {
		return dateTimeOfEnd.get();
	}

	public void setDateTimeOfEnd(final LocalDateTime dateTimeOfEnd) {
		this.dateTimeOfEnd.set(dateTimeOfEnd);
	}

	public SimpleObjectProperty<LocalDateTime> dateTimeOfEndProperty() {
		return dateTimeOfEnd;
	}

	public boolean getStopAfter() {
		return stopAfter.get();
	}

	public void setStopAfter(final boolean stopAfter) {
		this.stopAfter.set(stopAfter);
	}

	public SimpleBooleanProperty stopAfterProperty() {
		return stopAfter;
	}

	public String getId() {
		return id.get();
	}

	public void setId(final String id) {
		this.id.set(id);
	}

	public SimpleStringProperty idProperty() {
		return id;
	}

	public ObservableList<PlaylistModel> getPlaylists() {
		return playlists.get();
	}

	public void setPlaylists(final ObservableList<PlaylistModel> playlists) {
		this.playlists.set(playlists);
	}

	public SimpleListProperty<PlaylistModel> playlistsProperty() {
		return playlists;
	}

	public Social getSocial() {
		return social.get();
	}

	public void setSocial(final Social social) {
		this.social.set(social);
	}

	public SimpleObjectProperty<Social> socialProperty() {
		return social;
	}

	public Status getStatus() {
		return status.get();
	}

	public void setStatus(final Status status) {
		this.status.set(status);
	}

	public SimpleObjectProperty<Status> statusProperty() {
		return status;
	}

	public Monetization getMonetization() {
		return monetization.get();
	}

	public void setMonetization(final Monetization monetization) {
		this.monetization.set(monetization);
	}

	public SimpleObjectProperty<Monetization> monetizationProperty() {
		return monetization;
	}

	public Permissions getPermissions() {
		return permissions.get();
	}

	public void setPermissions(final Permissions permissions) {
		this.permissions.set(permissions);
	}

	public SimpleObjectProperty<Permissions> permissionsProperty() {
		return permissions;
	}

	public Metadata getMetadata() {
		return metadata.get();
	}

	public void setMetadata(final Metadata metadata) {
		this.metadata.set(metadata);
	}

	public SimpleObjectProperty<Metadata> metadataProperty() {
		return metadata;
	}

	public String getUploadurl() {
		return uploadurl.get();
	}

	public void setUploadurl(final String uploadurl) {
		this.uploadurl.set(uploadurl);
	}

	public SimpleStringProperty uploadurlProperty() {
		return uploadurl;
	}

	public String getVideoid() {
		return videoid.get();
	}

	public void setVideoid(final String videoid) {
		this.videoid.set(videoid);
	}

	public SimpleStringProperty videoidProperty() {
		return videoid;
	}

	public File getFile() {
		return file.get();
	}

	public void setFile(final File file) {
		this.file.set(file);
	}

	public SimpleObjectProperty<File> fileProperty() {
		return file;
	}

	public File getEnddir() {
		return enddir.get();
	}

	public void setEnddir(final File enddir) {
		this.enddir.set(enddir);
	}

	public SimpleObjectProperty<File> enddirProperty() {
		return enddir;
	}

	public File getThumbnail() {
		return thumbnail.get();
	}

	public void setThumbnail(final File thumbnail) {
		this.thumbnail.set(thumbnail);
	}

	public SimpleObjectProperty<File> thumbnailProperty() {
		return thumbnail;
	}

	public LocalDateTime getDateTimeOfStart() {
		return dateTimeOfStart.get();
	}

	public void setDateTimeOfStart(final LocalDateTime dateTimeOfStart) {
		if (null == dateTimeOfStart || dateTimeOfStart.isBefore(LocalDateTime.now())) {
			this.dateTimeOfStart.set(null);
		} else {
			this.dateTimeOfStart.set(dateTimeOfStart);
		}
	}

	public SimpleObjectProperty<LocalDateTime> dateTimeOfStartProperty() {
		return dateTimeOfStart;
	}

	public LocalDateTime getDateTimeOfRelease() {
		return dateTimeOfRelease.get();
	}

	@SuppressWarnings("MagicNumber")
	public void setDateTimeOfRelease(final LocalDateTime dateTimeOfRelease) {
		if (null == dateTimeOfRelease || dateTimeOfRelease.isBefore(LocalDateTime.now())) {
			this.dateTimeOfRelease.set(null);
		} else {
			final int mod = dateTimeOfRelease.getMinute() % 30;
			dateTimeOfRelease.plusMinutes(16 > mod ? -mod : 30 - mod)
							 .getMinute();
			this.dateTimeOfRelease.set(dateTimeOfRelease);
		}
	}

	public SimpleObjectProperty<LocalDateTime> dateTimeOfReleaseProperty() {
		return dateTimeOfRelease;
	}

	public int getOrder() {
		return order.get();
	}

	public void setOrder(final int order) {
		this.order.set(order);
	}

	public SimpleIntegerProperty orderProperty() {
		return order;
	}

	public AccountModel getAccount() {
		return account.get();
	}

	public void setAccount(final AccountModel account) {
		this.account.set(account);
	}

	public SimpleObjectProperty<AccountModel> accountProperty() {
		return account;
	}

	public String getMetadataTitle() {
		return metadata.get()
					   .getTitle();
	}

	public void setMetadataTitle(final String metadataTitle) {
		metadata.get()
				.setTitle(metadataTitle);
	}

	public String getMetadataDescription() {
		return metadata.get()
					   .getDescription();
	}

	public void setMetadataDescription(final String metadataDescription) {
		metadata.get()
				.setDescription(metadataDescription);
	}

	public String getMetadataTags() {
		return metadata.get()
					   .getTags();
	}

	public void setMetadataTags(final String metadataTags) {
		metadata.get()
				.setTags(metadataTags);
	}

	public String getSocialMessage() {
		return social.get()
					 .getMessage();
	}

	public void setSocialMessage(final String socialMessage) {
		social.get()
			  .setMessage(socialMessage);
	}

	public String getMonetizationTitle() {
		return monetization.get()
						   .getTitle();
	}

	public void setMonetizationTitle(final String monetizationTitle) {
		monetization.get()
					.setTitle(monetizationTitle);
	}

	public String getMonetizationDescription() {
		return monetization.get()
						   .getDescription();
	}

	public void setMonetizationDescription(final String monetizationDescription) {
		monetization.get()
					.setDescription(monetizationDescription);
	}

	public String getMonetizationCustomId() {
		return monetization.get()
						   .getCustomId();
	}

	public void setMonetizationCustomId(final String monetizationCustomId) {
		monetization.get()
					.setCustomId(monetizationCustomId);
	}

	public String getMonetizationNotes() {
		return monetization.get()
						   .getNotes();
	}

	public void setMonetizationNotes(final String monetizationNotes) {
		monetization.get()
					.setNotes(monetizationNotes);
	}

	public String getMonetizationTmsid() {
		return monetization.get()
						   .getTmsid();
	}

	public void setMonetizationTmsid(final String monetizationTmsid) {
		monetization.get()
					.setTmsid(monetizationTmsid);
	}

	public String getMonetizationEidr() {
		return monetization.get()
						   .getEidr();
	}

	public String getMonetizationTitleepisode() {
		return monetization.get()
						   .getEpisodeTitle();
	}

	public void setMonetizationTitleepisode(final String monetizationTitleepisode) {
		monetization.get()
					.setEpisodeTitle(monetizationTitleepisode);
	}

	public String getMonetizationSeasonNb() {
		return monetization.get()
						   .getSeasonNumber();
	}

	public void setMonetizationSeasonNb(final String monetizationSeasonNb) {
		monetization.get()
					.setSeasonNumber(monetizationSeasonNb);
	}

	public String getMonetizationEpisodeNb() {
		return monetization.get()
						   .getEpisodeNumber();
	}

	public void setMonetizationEpisodeNb(final String monetizationEpisodeNb) {
		monetization.get()
					.setEpisodeNumber(monetizationEpisodeNb);
	}

	public Visibility getPermissionsVisibility() {
		return permissions.get()
						  .getVisibility();
	}

	public boolean isSocialFacebook() {
		return social.get()
					 .getFacebook();
	}

	public boolean isSocialTwitter() {
		return social.get()
					 .getTwitter();
	}

	public boolean isSocialGplus() {
		return social.get()
					 .getGplus();
	}

	public boolean isMonetizationClaim() {
		return monetization.get()
						   .getClaim();
	}

	public License getMetadataLicense() {
		return metadata.get()
					   .getLicense();
	}

	public boolean isMonetizationPartner() {
		return monetization.get()
						   .getPartner();
	}

	public ClaimOption getMonetizationClaimoption() {
		return monetization.get()
						   .getClaimOption();
	}

	public boolean isMonetizationOverlay() {
		return monetization.get()
						   .getOverlay();
	}

	public boolean isMonetizationTrueview() {
		return monetization.get()
						   .getTrueview();
	}

	public boolean isMonetizationInstream() {
		return monetization.get()
						   .getInstream();
	}

	public boolean isMonetizationInstreamDefaults() {
		return monetization.get()
						   .getInstreamDefaults();
	}

	public boolean isMonetizationProduct() {
		return monetization.get()
						   .getProduct();
	}

	public Syndication getMonetizationSyndication() {
		return monetization.get()
						   .getSyndication();
	}

	public ClaimType getMonetizationClaimtype() {
		return monetization.get()
						   .getClaimType();
	}

	public Asset getMonetizationAsset() {
		return monetization.get()
						   .getAsset();
	}

	public String getMonetizationIsan() {
		return monetization.get()
						   .getIsan();
	}

	public void setMonetizationIsan(final String monetizationIsan) {
		monetization.get()
					.setIsan(monetizationIsan);
	}

	public boolean isPermissionsEmbed() {
		return permissions.get()
						  .getEmbed();
	}

	public boolean isPermissionsRate() {
		return permissions.get()
						  .getRate();
	}

	public boolean isPermissionsCommentvote() {
		return permissions.get()
						  .getCommentvote();
	}

	public Comment getPermissionsComment() {
		return permissions.get()
						  .getComment();
	}

	public boolean isPermissionsAgeRestricted() {
		return permissions.get()
						  .getAgeRestricted();
	}

	public boolean isPermissionsPublicStatsViewable() {
		return permissions.get()
						  .getPublicStatsViewable();
	}

	public ThreeD getPermissionsThreedD() {
		return permissions.get()
						  .getThreedD();
	}

	public String getMetadataLicenseIdentifier() {
		return metadata.get()
					   .getLicenseIdentifier();
	}

	public ObservableSet<CookieDTO> getAccountSerializableCookies() {
		return account.get()
					  .getCookies();
	}

	public String getPermissionsVisibilityIdentifier() {
		return permissions.get()
						  .getVisibilityIdentifier();
	}

	public String getCategoryId() {
		return metadata.get()
					   .getCategoryId();
	}

	public interface Validation {
		int MAX_THUMBNAIL_SIZE   = 2097152;
		int MAX_TITLE_SIZE       = 100;
		int MAX_DESCRIPTION_SIZE = 5000;

		String ACCOUNT                = "accountNull";
		String FILE                   = "fileNullNotExisting";
		String ENDDIR                 = "enddirNotExisting";
		String THUMBNAIL              = "thumbnailNotExsiting";
		String THUMBNAIL_SIZE         = "thumbnailSize";
		String TITLE                  = "titleNull";
		String TITLE_SIZE             = "titleSize";
		String TITLE_CHARACTERS       = "titleCharacters";
		String CATEGORY               = "categoryNull";
		String DESCRIPTION_SIZE       = "descriptionNull";
		String DESCRIPTION_CHARACTERS = "descriptionCharacters";
		String KEYWORD                = "keywordIllegal";
	}
}
