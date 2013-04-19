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
package org.chaosfisch.youtubeuploader.db.generated;

/**
 * This class is generated by jOOQ.
 * <p/>
 * A class modelling foreign key relationships between tables of the <code>PUBLIC</code>
 * schema
 */
@javax.annotation.Generated(value = {"http://www.jooq.org", "3.0.0"},
		comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({"all", "unchecked"})
public class Keys {

	// -------------------------------------------------------------------------
	// IDENTITY definitions
	// -------------------------------------------------------------------------

	public static final org.jooq.Identity<org.chaosfisch.youtubeuploader.db.generated.tables.records.AccountRecord, java.lang.Integer>          IDENTITY_ACCOUNT           = Identities0.IDENTITY_ACCOUNT;
	public static final org.jooq.Identity<org.chaosfisch.youtubeuploader.db.generated.tables.records.PlaylistRecord, java.lang.Integer>         IDENTITY_PLAYLIST          = Identities0.IDENTITY_PLAYLIST;
	public static final org.jooq.Identity<org.chaosfisch.youtubeuploader.db.generated.tables.records.TemplateRecord, java.lang.Integer>         IDENTITY_TEMPLATE          = Identities0.IDENTITY_TEMPLATE;
	public static final org.jooq.Identity<org.chaosfisch.youtubeuploader.db.generated.tables.records.TemplatePlaylistRecord, java.lang.Integer> IDENTITY_TEMPLATE_PLAYLIST = Identities0.IDENTITY_TEMPLATE_PLAYLIST;
	public static final org.jooq.Identity<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Integer>           IDENTITY_UPLOAD            = Identities0.IDENTITY_UPLOAD;
	public static final org.jooq.Identity<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadPlaylistRecord, java.lang.Integer>   IDENTITY_UPLOAD_PLAYLIST   = Identities0.IDENTITY_UPLOAD_PLAYLIST;

	// -------------------------------------------------------------------------
	// UNIQUE and PRIMARY KEY definitions
	// -------------------------------------------------------------------------

	public static final org.jooq.UniqueKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.AccountRecord>          CONSTRAINT_E  = UniqueKeys0.CONSTRAINT_E;
	public static final org.jooq.UniqueKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.PlaylistRecord>         CONSTRAINT_9  = UniqueKeys0.CONSTRAINT_9;
	public static final org.jooq.UniqueKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.TemplateRecord>         CONSTRAINT_D  = UniqueKeys0.CONSTRAINT_D;
	public static final org.jooq.UniqueKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.TemplatePlaylistRecord> CONSTRAINT_F  = UniqueKeys0.CONSTRAINT_F;
	public static final org.jooq.UniqueKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord>           CONSTRAINT_95 = UniqueKeys0.CONSTRAINT_95;
	public static final org.jooq.UniqueKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadPlaylistRecord>   CONSTRAINT_EF = UniqueKeys0.CONSTRAINT_EF;

	// -------------------------------------------------------------------------
	// FOREIGN KEY definitions
	// -------------------------------------------------------------------------

	public static final org.jooq.ForeignKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.PlaylistRecord, org.chaosfisch.youtubeuploader.db.generated.tables.records.AccountRecord> CONSTRAINT_36  = ForeignKeys0.CONSTRAINT_36;
	public static final org.jooq.ForeignKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.TemplateRecord, org.chaosfisch.youtubeuploader.db.generated.tables.records.AccountRecord> CONSTRAINT_1C  = ForeignKeys0.CONSTRAINT_1C;
	public static final org.jooq.ForeignKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, org.chaosfisch.youtubeuploader.db.generated.tables.records.AccountRecord>   CONSTRAINT_1D4 = ForeignKeys0.CONSTRAINT_1D4;

	// -------------------------------------------------------------------------
	// [#1459] distribute members to avoid static initialisers > 64kb
	// -------------------------------------------------------------------------

	private static class Identities0 extends org.jooq.impl.AbstractKeys {
		public static org.jooq.Identity<org.chaosfisch.youtubeuploader.db.generated.tables.records.AccountRecord, java.lang.Integer>          IDENTITY_ACCOUNT           = createIdentity(org.chaosfisch.youtubeuploader.db.generated.tables.Account.ACCOUNT, org.chaosfisch.youtubeuploader.db.generated.tables.Account.ACCOUNT.ID);
		public static org.jooq.Identity<org.chaosfisch.youtubeuploader.db.generated.tables.records.PlaylistRecord, java.lang.Integer>         IDENTITY_PLAYLIST          = createIdentity(org.chaosfisch.youtubeuploader.db.generated.tables.Playlist.PLAYLIST, org.chaosfisch.youtubeuploader.db.generated.tables.Playlist.PLAYLIST.ID);
		public static org.jooq.Identity<org.chaosfisch.youtubeuploader.db.generated.tables.records.TemplateRecord, java.lang.Integer>         IDENTITY_TEMPLATE          = createIdentity(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE, org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.ID);
		public static org.jooq.Identity<org.chaosfisch.youtubeuploader.db.generated.tables.records.TemplatePlaylistRecord, java.lang.Integer> IDENTITY_TEMPLATE_PLAYLIST = createIdentity(org.chaosfisch.youtubeuploader.db.generated.tables.TemplatePlaylist.TEMPLATE_PLAYLIST, org.chaosfisch.youtubeuploader.db.generated.tables.TemplatePlaylist.TEMPLATE_PLAYLIST.ID);
		public static org.jooq.Identity<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Integer>           IDENTITY_UPLOAD            = createIdentity(org.chaosfisch.youtubeuploader.db.generated.tables.Upload.UPLOAD, org.chaosfisch.youtubeuploader.db.generated.tables.Upload.UPLOAD.ID);
		public static org.jooq.Identity<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadPlaylistRecord, java.lang.Integer>   IDENTITY_UPLOAD_PLAYLIST   = createIdentity(org.chaosfisch.youtubeuploader.db.generated.tables.UploadPlaylist.UPLOAD_PLAYLIST, org.chaosfisch.youtubeuploader.db.generated.tables.UploadPlaylist.UPLOAD_PLAYLIST.ID);
	}

	private static class UniqueKeys0 extends org.jooq.impl.AbstractKeys {
		public static final org.jooq.UniqueKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.AccountRecord>          CONSTRAINT_E  = createUniqueKey(org.chaosfisch.youtubeuploader.db.generated.tables.Account.ACCOUNT, org.chaosfisch.youtubeuploader.db.generated.tables.Account.ACCOUNT.ID);
		public static final org.jooq.UniqueKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.PlaylistRecord>         CONSTRAINT_9  = createUniqueKey(org.chaosfisch.youtubeuploader.db.generated.tables.Playlist.PLAYLIST, org.chaosfisch.youtubeuploader.db.generated.tables.Playlist.PLAYLIST.ID);
		public static final org.jooq.UniqueKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.TemplateRecord>         CONSTRAINT_D  = createUniqueKey(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE, org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.ID);
		public static final org.jooq.UniqueKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.TemplatePlaylistRecord> CONSTRAINT_F  = createUniqueKey(org.chaosfisch.youtubeuploader.db.generated.tables.TemplatePlaylist.TEMPLATE_PLAYLIST, org.chaosfisch.youtubeuploader.db.generated.tables.TemplatePlaylist.TEMPLATE_PLAYLIST.ID);
		public static final org.jooq.UniqueKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord>           CONSTRAINT_95 = createUniqueKey(org.chaosfisch.youtubeuploader.db.generated.tables.Upload.UPLOAD, org.chaosfisch.youtubeuploader.db.generated.tables.Upload.UPLOAD.ID);
		public static final org.jooq.UniqueKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadPlaylistRecord>   CONSTRAINT_EF = createUniqueKey(org.chaosfisch.youtubeuploader.db.generated.tables.UploadPlaylist.UPLOAD_PLAYLIST, org.chaosfisch.youtubeuploader.db.generated.tables.UploadPlaylist.UPLOAD_PLAYLIST.ID);
	}

	private static class ForeignKeys0 extends org.jooq.impl.AbstractKeys {
		public static final org.jooq.ForeignKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.PlaylistRecord, org.chaosfisch.youtubeuploader.db.generated.tables.records.AccountRecord> CONSTRAINT_36  = createForeignKey(org.chaosfisch.youtubeuploader.db.generated.Keys.CONSTRAINT_E, org.chaosfisch.youtubeuploader.db.generated.tables.Playlist.PLAYLIST, org.chaosfisch.youtubeuploader.db.generated.tables.Playlist.PLAYLIST.ACCOUNT_ID);
		public static final org.jooq.ForeignKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.TemplateRecord, org.chaosfisch.youtubeuploader.db.generated.tables.records.AccountRecord> CONSTRAINT_1C  = createForeignKey(org.chaosfisch.youtubeuploader.db.generated.Keys.CONSTRAINT_E, org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE, org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.ACCOUNT_ID);
		public static final org.jooq.ForeignKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, org.chaosfisch.youtubeuploader.db.generated.tables.records.AccountRecord>   CONSTRAINT_1D4 = createForeignKey(org.chaosfisch.youtubeuploader.db.generated.Keys.CONSTRAINT_E, org.chaosfisch.youtubeuploader.db.generated.tables.Upload.UPLOAD, org.chaosfisch.youtubeuploader.db.generated.tables.Upload.UPLOAD.ACCOUNT_ID);
	}
}