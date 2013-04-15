/**
 * This class is generated by jOOQ
 */
package org.chaosfisch.youtubeuploader.db.generated.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "3.0.0"},
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked" })
public class Upload extends org.jooq.impl.TableImpl<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord> {

	private static final long serialVersionUID = 427756363;

	/**
	 * The singleton instance of <code>PUBLIC.UPLOAD</code>
	 */
	public static final org.chaosfisch.youtubeuploader.db.generated.tables.Upload UPLOAD = new org.chaosfisch.youtubeuploader.db.generated.tables.Upload();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord> getRecordType() {
		return org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord.class;
	}

	/**
	 * The column <code>PUBLIC.UPLOAD.ID</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Integer> ID = createField("ID", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The column <code>PUBLIC.UPLOAD.ARCHIVED</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Boolean> ARCHIVED = createField("ARCHIVED", org.jooq.impl.SQLDataType.BOOLEAN, this);

	/**
	 * The column <code>PUBLIC.UPLOAD.CATEGORY</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, org.chaosfisch.youtubeuploader.db.data.Category> CATEGORY = createField("CATEGORY", org.jooq.impl.SQLDataType.VARCHAR.length(255).asConvertedDataType(new org.chaosfisch.youtubeuploader.db.converter.CategoryConverter()), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.COMMENT</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, org.chaosfisch.youtubeuploader.db.data.Comment> COMMENT = createField("COMMENT", org.jooq.impl.SQLDataType.VARCHAR.length(255).asConvertedDataType(new org.chaosfisch.youtubeuploader.db.converter.CommentConverter()), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.COMMENTVOTE</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Boolean> COMMENTVOTE = createField("COMMENTVOTE", org.jooq.impl.SQLDataType.BOOLEAN, this);

	/**
	 * The column <code>PUBLIC.UPLOAD.DESCRIPTION</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.String> DESCRIPTION = createField("DESCRIPTION", org.jooq.impl.SQLDataType.VARCHAR.length(10000), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.EMBED</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Boolean> EMBED = createField("EMBED", org.jooq.impl.SQLDataType.BOOLEAN, this);

	/**
	 * The column <code>PUBLIC.UPLOAD.FAILED</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Boolean> FAILED = createField("FAILED", org.jooq.impl.SQLDataType.BOOLEAN, this);

	/**
	 * The column <code>PUBLIC.UPLOAD.FILE</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.io.File> FILE = createField("FILE", org.jooq.impl.SQLDataType.VARCHAR.length(500).asConvertedDataType(new org.chaosfisch.youtubeuploader.db.converter.FileConverter()), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.VISIBILITY</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, org.chaosfisch.youtubeuploader.db.data.Visibility> VISIBILITY = createField("VISIBILITY", org.jooq.impl.SQLDataType.VARCHAR.length(255).asConvertedDataType(new org.chaosfisch.youtubeuploader.db.converter.VisibilityConverter()), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.KEYWORDS</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.String> KEYWORDS = createField("KEYWORDS", org.jooq.impl.SQLDataType.VARCHAR.length(1000), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MIMETYPE</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.String> MIMETYPE = createField("MIMETYPE", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MOBILE</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Boolean> MOBILE = createField("MOBILE", org.jooq.impl.SQLDataType.BOOLEAN, this);

	/**
	 * The column <code>PUBLIC.UPLOAD.RATE</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Boolean> RATE = createField("RATE", org.jooq.impl.SQLDataType.BOOLEAN, this);

	/**
	 * The column <code>PUBLIC.UPLOAD.TITLE</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.String> TITLE = createField("TITLE", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.UPLOADURL</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.String> UPLOADURL = createField("UPLOADURL", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.VIDEORESPONSE</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, org.chaosfisch.youtubeuploader.db.data.Videoresponse> VIDEORESPONSE = createField("VIDEORESPONSE", org.jooq.impl.SQLDataType.VARCHAR.length(255).asConvertedDataType(new org.chaosfisch.youtubeuploader.db.converter.VideoresponseConverter()), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.DATE_OF_START</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.util.Calendar> DATE_OF_START = createField("DATE_OF_START", org.jooq.impl.SQLDataType.TIMESTAMP.asConvertedDataType(new org.chaosfisch.youtubeuploader.db.converter.CalendarConverter()), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.INPROGRESS</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Boolean> INPROGRESS = createField("INPROGRESS", org.jooq.impl.SQLDataType.BOOLEAN, this);

	/**
	 * The column <code>PUBLIC.UPLOAD.LOCKED</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Boolean> LOCKED = createField("LOCKED", org.jooq.impl.SQLDataType.BOOLEAN, this);

	/**
	 * The column <code>PUBLIC.UPLOAD.VIDEOID</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.String> VIDEOID = createField("VIDEOID", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.ACCOUNT_ID</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Integer> ACCOUNT_ID = createField("ACCOUNT_ID", org.jooq.impl.SQLDataType.INTEGER, this);

	/**
	 * The column <code>PUBLIC.UPLOAD.ENDDIR</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.io.File> ENDDIR = createField("ENDDIR", org.jooq.impl.SQLDataType.VARCHAR.length(255).asConvertedDataType(new org.chaosfisch.youtubeuploader.db.converter.FileConverter()), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.LICENSE</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, org.chaosfisch.youtubeuploader.db.data.License> LICENSE = createField("LICENSE", org.jooq.impl.SQLDataType.VARCHAR.length(255).asConvertedDataType(new org.chaosfisch.youtubeuploader.db.converter.LicenseConverter()), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.DATE_OF_RELEASE</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.util.Calendar> DATE_OF_RELEASE = createField("DATE_OF_RELEASE", org.jooq.impl.SQLDataType.TIMESTAMP.asConvertedDataType(new org.chaosfisch.youtubeuploader.db.converter.CalendarConverter()), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.NUMBER</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Short> NUMBER = createField("NUMBER", org.jooq.impl.SQLDataType.SMALLINT, this);

	/**
	 * The column <code>PUBLIC.UPLOAD.PAUSEONFINISH</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Boolean> PAUSEONFINISH = createField("PAUSEONFINISH", org.jooq.impl.SQLDataType.BOOLEAN, this);

	/**
	 * The column <code>PUBLIC.UPLOAD.THUMBNAIL</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.String> THUMBNAIL = createField("THUMBNAIL", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.FACEBOOK</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Boolean> FACEBOOK = createField("FACEBOOK", org.jooq.impl.SQLDataType.BOOLEAN, this);

	/**
	 * The column <code>PUBLIC.UPLOAD.TWITTER</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Boolean> TWITTER = createField("TWITTER", org.jooq.impl.SQLDataType.BOOLEAN, this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MESSAGE</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.String> MESSAGE = createField("MESSAGE", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MONETIZE_INSTREAM_DEFAULTS</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Boolean> MONETIZE_INSTREAM_DEFAULTS = createField("MONETIZE_INSTREAM_DEFAULTS", org.jooq.impl.SQLDataType.BOOLEAN, this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MONETIZE_CLAIM</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Boolean> MONETIZE_CLAIM = createField("MONETIZE_CLAIM", org.jooq.impl.SQLDataType.BOOLEAN, this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MONETIZE_OVERLAY</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Boolean> MONETIZE_OVERLAY = createField("MONETIZE_OVERLAY", org.jooq.impl.SQLDataType.BOOLEAN, this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MONETIZE_TRUEVIEW</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Boolean> MONETIZE_TRUEVIEW = createField("MONETIZE_TRUEVIEW", org.jooq.impl.SQLDataType.BOOLEAN, this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MONETIZE_INSTREAM</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Boolean> MONETIZE_INSTREAM = createField("MONETIZE_INSTREAM", org.jooq.impl.SQLDataType.BOOLEAN, this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MONETIZE_PRODUCT</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Boolean> MONETIZE_PRODUCT = createField("MONETIZE_PRODUCT", org.jooq.impl.SQLDataType.BOOLEAN, this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MONETIZE_SYNDICATION</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, org.chaosfisch.youtubeuploader.db.data.Syndication> MONETIZE_SYNDICATION = createField("MONETIZE_SYNDICATION", org.jooq.impl.SQLDataType.VARCHAR.length(255).asConvertedDataType(new org.chaosfisch.youtubeuploader.db.converter.SyndicationConverter()), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MONETIZE_TITLE</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.String> MONETIZE_TITLE = createField("MONETIZE_TITLE", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MONETIZE_DESCRIPTION</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.String> MONETIZE_DESCRIPTION = createField("MONETIZE_DESCRIPTION", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MONETIZE_ID</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.String> MONETIZE_ID = createField("MONETIZE_ID", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MONETIZE_NOTES</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.String> MONETIZE_NOTES = createField("MONETIZE_NOTES", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MONETIZE_TMSID</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.String> MONETIZE_TMSID = createField("MONETIZE_TMSID", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MONETIZE_ISAN</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.String> MONETIZE_ISAN = createField("MONETIZE_ISAN", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MONETIZE_EIDR</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.String> MONETIZE_EIDR = createField("MONETIZE_EIDR", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MONETIZE_TITLEEPISODE</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.String> MONETIZE_TITLEEPISODE = createField("MONETIZE_TITLEEPISODE", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MONETIZE_SEASON_NB</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.String> MONETIZE_SEASON_NB = createField("MONETIZE_SEASON_NB", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MONETIZE_EPISODE_NB</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.String> MONETIZE_EPISODE_NB = createField("MONETIZE_EPISODE_NB", org.jooq.impl.SQLDataType.VARCHAR.length(255), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MONETIZE_CLAIMTYPE</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, org.chaosfisch.youtubeuploader.db.data.ClaimType> MONETIZE_CLAIMTYPE = createField("MONETIZE_CLAIMTYPE", org.jooq.impl.SQLDataType.VARCHAR.length(255).asConvertedDataType(new org.chaosfisch.youtubeuploader.db.converter.ClaimTypeConverter()), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MONETIZE_CLAIMOPTION</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, org.chaosfisch.youtubeuploader.db.data.ClaimOption> MONETIZE_CLAIMOPTION = createField("MONETIZE_CLAIMOPTION", org.jooq.impl.SQLDataType.VARCHAR.length(255).asConvertedDataType(new org.chaosfisch.youtubeuploader.db.converter.ClaimOptionConverter()), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MONETIZE_ASSET</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, org.chaosfisch.youtubeuploader.db.data.Asset> MONETIZE_ASSET = createField("MONETIZE_ASSET", org.jooq.impl.SQLDataType.VARCHAR.length(255).asConvertedDataType(new org.chaosfisch.youtubeuploader.db.converter.AssetConverter()), this);

	/**
	 * The column <code>PUBLIC.UPLOAD.MONETIZE_PARTNER</code>. 
	 */
	public final org.jooq.TableField<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Boolean> MONETIZE_PARTNER = createField("MONETIZE_PARTNER", org.jooq.impl.SQLDataType.BOOLEAN, this);

	/**
	 * Create a <code>PUBLIC.UPLOAD</code> table reference
	 */
	public Upload() {
		super("UPLOAD", org.chaosfisch.youtubeuploader.db.generated.Public.PUBLIC);
	}

	/**
	 * Create an aliased <code>PUBLIC.UPLOAD</code> table reference
	 */
	public Upload(java.lang.String alias) {
		super(alias, org.chaosfisch.youtubeuploader.db.generated.Public.PUBLIC, org.chaosfisch.youtubeuploader.db.generated.tables.Upload.UPLOAD);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, java.lang.Integer> getIdentity() {
		return org.chaosfisch.youtubeuploader.db.generated.Keys.IDENTITY_UPLOAD;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord> getPrimaryKey() {
		return org.chaosfisch.youtubeuploader.db.generated.Keys.CONSTRAINT_95;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord>>asList(org.chaosfisch.youtubeuploader.db.generated.Keys.CONSTRAINT_95);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<org.chaosfisch.youtubeuploader.db.generated.tables.records.UploadRecord, ?>>asList(org.chaosfisch.youtubeuploader.db.generated.Keys.CONSTRAINT_1D4);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.chaosfisch.youtubeuploader.db.generated.tables.Upload as(java.lang.String alias) {
		return new org.chaosfisch.youtubeuploader.db.generated.tables.Upload(alias);
	}
}
