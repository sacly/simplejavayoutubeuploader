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
import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.List;

public class Upload implements Serializable {

	private static final long serialVersionUID = -414398454;

	private int               id;
	private File              file;
	private String            mimetype;
	private String            uploadurl;
	private GregorianCalendar dateOfStart;
	private GregorianCalendar dateOfRelease;
	private boolean           pauseOnFinish;
	private String            videoid;
	private File              enddir;
	private File              thumbnail;

	private Social         social;
	private Status         status;
	private Monetization   monetization;
	private Permissions    permissions;
	private Metadata       metadata;
	private Account        account;
	private List<Playlist> playlists;

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public File getFile() {
		return file;
	}

	public void setFile(final File file) {
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

	public GregorianCalendar getDateOfStart() {
		return dateOfStart;
	}

	public void setDateOfStart(final GregorianCalendar dateOfStart) {
		this.dateOfStart = dateOfStart;
	}

	public GregorianCalendar getDateOfRelease() {
		return dateOfRelease;
	}

	public void setDateOfRelease(final GregorianCalendar dateOfRelease) {
		this.dateOfRelease = dateOfRelease;
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
		this.enddir = enddir;
	}

	public File getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(final File thumbnail) {
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
		return playlists;
	}

	public void setPlaylists(final List<Playlist> playlists) {
		this.playlists = playlists;
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

		return id == upload.id;
	}

	@Override
	public int hashCode() {
		return id;
	}
}
