/*******************************************************************************
 * Copyright (c) 2013 Dennis Fischer.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0+
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 * 
 * Contributors: Dennis Fischer
 ******************************************************************************/
/**
 * This class is generated by jOOQ
 */
package org.chaosfisch.youtubeuploader.db.generated;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "3.0.0"},
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked" })
public class Public extends org.jooq.impl.SchemaImpl {

	private static final long serialVersionUID = 1021399366;

	/**
	 * The singleton instance of <code>PUBLIC</code>
	 */
	public static final Public PUBLIC = new Public();

	/**
	 * No further instances allowed
	 */
	private Public() {
		super("PUBLIC");
	}

	@Override
	public final java.util.List<org.jooq.Sequence<?>> getSequences() {
		java.util.List result = new java.util.ArrayList();
		result.addAll(getSequences0());
		return result;
	}

	private final java.util.List<org.jooq.Sequence<?>> getSequences0() {
		return java.util.Arrays.<org.jooq.Sequence<?>>asList(
			org.chaosfisch.youtubeuploader.db.generated.Sequences.SYSTEM_SEQUENCE_148038CE_E56F_4055_9F13_9E577363B84D,
			org.chaosfisch.youtubeuploader.db.generated.Sequences.SYSTEM_SEQUENCE_173AE841_37EE_40F9_BBDF_455DA37A217B,
			org.chaosfisch.youtubeuploader.db.generated.Sequences.SYSTEM_SEQUENCE_6AA13B5E_5F81_4238_A344_5838CBDE8269,
			org.chaosfisch.youtubeuploader.db.generated.Sequences.SYSTEM_SEQUENCE_94D1C0E6_28A1_4B9E_9A07_E9772DE88688,
			org.chaosfisch.youtubeuploader.db.generated.Sequences.SYSTEM_SEQUENCE_B62F8C6F_F904_4FE2_831A_EFD9C4BFDDC0,
			org.chaosfisch.youtubeuploader.db.generated.Sequences.SYSTEM_SEQUENCE_F6C040C7_CFD1_4B1B_B4EA_BC84BBC2C8BE);
	}

	@Override
	public final java.util.List<org.jooq.Table<?>> getTables() {
		java.util.List result = new java.util.ArrayList();
		result.addAll(getTables0());
		return result;
	}

	private final java.util.List<org.jooq.Table<?>> getTables0() {
		return java.util.Arrays.<org.jooq.Table<?>>asList(
			org.chaosfisch.youtubeuploader.db.generated.tables.Account.ACCOUNT,
			org.chaosfisch.youtubeuploader.db.generated.tables.Playlist.PLAYLIST,
			org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE,
			org.chaosfisch.youtubeuploader.db.generated.tables.TemplatePlaylist.TEMPLATE_PLAYLIST,
			org.chaosfisch.youtubeuploader.db.generated.tables.Upload.UPLOAD,
			org.chaosfisch.youtubeuploader.db.generated.tables.UploadPlaylist.UPLOAD_PLAYLIST);
	}
}
