/**
 * This class is generated by jOOQ
 */
package org.chaosfisch.youtubeuploader.db.generated.tables.records;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "3.0.0"},
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked" })
public class TemplateRecord extends org.jooq.impl.UpdatableRecordImpl<org.chaosfisch.youtubeuploader.db.generated.tables.records.TemplateRecord> {

	private static final long serialVersionUID = 1236044046;

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.ID</code>. 
	 */
	public void setId(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.ID</code>. 
	 */
	public java.lang.Integer getId() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.CATEGORY</code>. 
	 */
	public void setCategory(org.chaosfisch.youtubeuploader.db.data.Category value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.CATEGORY</code>. 
	 */
	public org.chaosfisch.youtubeuploader.db.data.Category getCategory() {
		return (org.chaosfisch.youtubeuploader.db.data.Category) getValue(1);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.COMMENT</code>. 
	 */
	public void setComment(org.chaosfisch.youtubeuploader.db.data.Comment value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.COMMENT</code>. 
	 */
	public org.chaosfisch.youtubeuploader.db.data.Comment getComment() {
		return (org.chaosfisch.youtubeuploader.db.data.Comment) getValue(2);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.COMMENTVOTE</code>. 
	 */
	public void setCommentvote(java.lang.Boolean value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.COMMENTVOTE</code>. 
	 */
	public java.lang.Boolean getCommentvote() {
		return (java.lang.Boolean) getValue(3);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.DEFAULTDIR</code>. 
	 */
	public void setDefaultdir(java.io.File value) {
		setValue(4, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.DEFAULTDIR</code>. 
	 */
	public java.io.File getDefaultdir() {
		return (java.io.File) getValue(4);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.DESCRIPTION</code>. 
	 */
	public void setDescription(java.lang.String value) {
		setValue(5, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.DESCRIPTION</code>. 
	 */
	public java.lang.String getDescription() {
		return (java.lang.String) getValue(5);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.EMBED</code>. 
	 */
	public void setEmbed(java.lang.Boolean value) {
		setValue(6, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.EMBED</code>. 
	 */
	public java.lang.Boolean getEmbed() {
		return (java.lang.Boolean) getValue(6);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.KEYWORDS</code>. 
	 */
	public void setKeywords(java.lang.String value) {
		setValue(7, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.KEYWORDS</code>. 
	 */
	public java.lang.String getKeywords() {
		return (java.lang.String) getValue(7);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.MOBILE</code>. 
	 */
	public void setMobile(java.lang.Boolean value) {
		setValue(8, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.MOBILE</code>. 
	 */
	public java.lang.Boolean getMobile() {
		return (java.lang.Boolean) getValue(8);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.NAME</code>. 
	 */
	public void setName(java.lang.String value) {
		setValue(9, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.NAME</code>. 
	 */
	public java.lang.String getName() {
		return (java.lang.String) getValue(9);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.NUMBER</code>. 
	 */
	public void setNumber(java.lang.Short value) {
		setValue(10, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.NUMBER</code>. 
	 */
	public java.lang.Short getNumber() {
		return (java.lang.Short) getValue(10);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.RATE</code>. 
	 */
	public void setRate(java.lang.Boolean value) {
		setValue(11, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.RATE</code>. 
	 */
	public java.lang.Boolean getRate() {
		return (java.lang.Boolean) getValue(11);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.VIDEORESPONSE</code>. 
	 */
	public void setVideoresponse(org.chaosfisch.youtubeuploader.db.data.Videoresponse value) {
		setValue(12, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.VIDEORESPONSE</code>. 
	 */
	public org.chaosfisch.youtubeuploader.db.data.Videoresponse getVideoresponse() {
		return (org.chaosfisch.youtubeuploader.db.data.Videoresponse) getValue(12);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.VISIBILITY</code>. 
	 */
	public void setVisibility(org.chaosfisch.youtubeuploader.db.data.Visibility value) {
		setValue(13, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.VISIBILITY</code>. 
	 */
	public org.chaosfisch.youtubeuploader.db.data.Visibility getVisibility() {
		return (org.chaosfisch.youtubeuploader.db.data.Visibility) getValue(13);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.ACCOUNT_ID</code>. 
	 */
	public void setAccountId(java.lang.Integer value) {
		setValue(14, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.ACCOUNT_ID</code>. 
	 */
	public java.lang.Integer getAccountId() {
		return (java.lang.Integer) getValue(14);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.ENDDIR</code>. 
	 */
	public void setEnddir(java.io.File value) {
		setValue(15, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.ENDDIR</code>. 
	 */
	public java.io.File getEnddir() {
		return (java.io.File) getValue(15);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.LICENSE</code>. 
	 */
	public void setLicense(org.chaosfisch.youtubeuploader.db.data.License value) {
		setValue(16, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.LICENSE</code>. 
	 */
	public org.chaosfisch.youtubeuploader.db.data.License getLicense() {
		return (org.chaosfisch.youtubeuploader.db.data.License) getValue(16);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.TITLE</code>. 
	 */
	public void setTitle(java.lang.String value) {
		setValue(17, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.TITLE</code>. 
	 */
	public java.lang.String getTitle() {
		return (java.lang.String) getValue(17);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.THUMBNAIL</code>. 
	 */
	public void setThumbnail(java.lang.String value) {
		setValue(18, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.THUMBNAIL</code>. 
	 */
	public java.lang.String getThumbnail() {
		return (java.lang.String) getValue(18);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.FACEBOOK</code>. 
	 */
	public void setFacebook(java.lang.Boolean value) {
		setValue(19, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.FACEBOOK</code>. 
	 */
	public java.lang.Boolean getFacebook() {
		return (java.lang.Boolean) getValue(19);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.TWITTER</code>. 
	 */
	public void setTwitter(java.lang.Boolean value) {
		setValue(20, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.TWITTER</code>. 
	 */
	public java.lang.Boolean getTwitter() {
		return (java.lang.Boolean) getValue(20);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.MESSAGE</code>. 
	 */
	public void setMessage(java.lang.String value) {
		setValue(21, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.MESSAGE</code>. 
	 */
	public java.lang.String getMessage() {
		return (java.lang.String) getValue(21);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.MONETIZE_INSTREAM_DEFAULTS</code>. 
	 */
	public void setMonetizeInstreamDefaults(java.lang.Boolean value) {
		setValue(22, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.MONETIZE_INSTREAM_DEFAULTS</code>. 
	 */
	public java.lang.Boolean getMonetizeInstreamDefaults() {
		return (java.lang.Boolean) getValue(22);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.MONETIZE_CLAIM</code>. 
	 */
	public void setMonetizeClaim(java.lang.Boolean value) {
		setValue(23, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.MONETIZE_CLAIM</code>. 
	 */
	public java.lang.Boolean getMonetizeClaim() {
		return (java.lang.Boolean) getValue(23);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.MONETIZE_OVERLAY</code>. 
	 */
	public void setMonetizeOverlay(java.lang.Boolean value) {
		setValue(24, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.MONETIZE_OVERLAY</code>. 
	 */
	public java.lang.Boolean getMonetizeOverlay() {
		return (java.lang.Boolean) getValue(24);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.MONETIZE_TRUEVIEW</code>. 
	 */
	public void setMonetizeTrueview(java.lang.Boolean value) {
		setValue(25, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.MONETIZE_TRUEVIEW</code>. 
	 */
	public java.lang.Boolean getMonetizeTrueview() {
		return (java.lang.Boolean) getValue(25);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.MONETIZE_INSTREAM</code>. 
	 */
	public void setMonetizeInstream(java.lang.Boolean value) {
		setValue(26, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.MONETIZE_INSTREAM</code>. 
	 */
	public java.lang.Boolean getMonetizeInstream() {
		return (java.lang.Boolean) getValue(26);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.MONETIZE_PRODUCT</code>. 
	 */
	public void setMonetizeProduct(java.lang.Boolean value) {
		setValue(27, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.MONETIZE_PRODUCT</code>. 
	 */
	public java.lang.Boolean getMonetizeProduct() {
		return (java.lang.Boolean) getValue(27);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.MONETIZE_SYNDICATION</code>. 
	 */
	public void setMonetizeSyndication(org.chaosfisch.youtubeuploader.db.data.Syndication value) {
		setValue(28, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.MONETIZE_SYNDICATION</code>. 
	 */
	public org.chaosfisch.youtubeuploader.db.data.Syndication getMonetizeSyndication() {
		return (org.chaosfisch.youtubeuploader.db.data.Syndication) getValue(28);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.MONETIZE_TITLE</code>. 
	 */
	public void setMonetizeTitle(java.lang.String value) {
		setValue(29, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.MONETIZE_TITLE</code>. 
	 */
	public java.lang.String getMonetizeTitle() {
		return (java.lang.String) getValue(29);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.MONETIZE_DESCRIPTION</code>. 
	 */
	public void setMonetizeDescription(java.lang.String value) {
		setValue(30, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.MONETIZE_DESCRIPTION</code>. 
	 */
	public java.lang.String getMonetizeDescription() {
		return (java.lang.String) getValue(30);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.MONETIZE_ID</code>. 
	 */
	public void setMonetizeId(java.lang.String value) {
		setValue(31, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.MONETIZE_ID</code>. 
	 */
	public java.lang.String getMonetizeId() {
		return (java.lang.String) getValue(31);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.MONETIZE_NOTES</code>. 
	 */
	public void setMonetizeNotes(java.lang.String value) {
		setValue(32, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.MONETIZE_NOTES</code>. 
	 */
	public java.lang.String getMonetizeNotes() {
		return (java.lang.String) getValue(32);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.MONETIZE_TMSID</code>. 
	 */
	public void setMonetizeTmsid(java.lang.String value) {
		setValue(33, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.MONETIZE_TMSID</code>. 
	 */
	public java.lang.String getMonetizeTmsid() {
		return (java.lang.String) getValue(33);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.MONETIZE_ISAN</code>. 
	 */
	public void setMonetizeIsan(java.lang.String value) {
		setValue(34, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.MONETIZE_ISAN</code>. 
	 */
	public java.lang.String getMonetizeIsan() {
		return (java.lang.String) getValue(34);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.MONETIZE_EIDR</code>. 
	 */
	public void setMonetizeEidr(java.lang.String value) {
		setValue(35, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.MONETIZE_EIDR</code>. 
	 */
	public java.lang.String getMonetizeEidr() {
		return (java.lang.String) getValue(35);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.MONETIZE_TITLEEPISODE</code>. 
	 */
	public void setMonetizeTitleepisode(java.lang.String value) {
		setValue(36, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.MONETIZE_TITLEEPISODE</code>. 
	 */
	public java.lang.String getMonetizeTitleepisode() {
		return (java.lang.String) getValue(36);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.MONETIZE_SEASON_NB</code>. 
	 */
	public void setMonetizeSeasonNb(java.lang.String value) {
		setValue(37, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.MONETIZE_SEASON_NB</code>. 
	 */
	public java.lang.String getMonetizeSeasonNb() {
		return (java.lang.String) getValue(37);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.MONETIZE_EPISODE_NB</code>. 
	 */
	public void setMonetizeEpisodeNb(java.lang.String value) {
		setValue(38, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.MONETIZE_EPISODE_NB</code>. 
	 */
	public java.lang.String getMonetizeEpisodeNb() {
		return (java.lang.String) getValue(38);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.MONETIZE_CLAIMTYPE</code>. 
	 */
	public void setMonetizeClaimtype(org.chaosfisch.youtubeuploader.db.data.ClaimType value) {
		setValue(39, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.MONETIZE_CLAIMTYPE</code>. 
	 */
	public org.chaosfisch.youtubeuploader.db.data.ClaimType getMonetizeClaimtype() {
		return (org.chaosfisch.youtubeuploader.db.data.ClaimType) getValue(39);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.MONETIZE_CLAIMOPTION</code>. 
	 */
	public void setMonetizeClaimoption(org.chaosfisch.youtubeuploader.db.data.ClaimOption value) {
		setValue(40, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.MONETIZE_CLAIMOPTION</code>. 
	 */
	public org.chaosfisch.youtubeuploader.db.data.ClaimOption getMonetizeClaimoption() {
		return (org.chaosfisch.youtubeuploader.db.data.ClaimOption) getValue(40);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.MONETIZE_ASSET</code>. 
	 */
	public void setMonetizeAsset(org.chaosfisch.youtubeuploader.db.data.Asset value) {
		setValue(41, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.MONETIZE_ASSET</code>. 
	 */
	public org.chaosfisch.youtubeuploader.db.data.Asset getMonetizeAsset() {
		return (org.chaosfisch.youtubeuploader.db.data.Asset) getValue(41);
	}

	/**
	 * Setter for <code>PUBLIC.TEMPLATE.MONETIZE_PARTNER</code>. 
	 */
	public void setMonetizePartner(java.lang.Boolean value) {
		setValue(42, value);
	}

	/**
	 * Getter for <code>PUBLIC.TEMPLATE.MONETIZE_PARTNER</code>. 
	 */
	public java.lang.Boolean getMonetizePartner() {
		return (java.lang.Boolean) getValue(42);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.Integer> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached TemplateRecord
	 */
	public TemplateRecord() {
		super(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE);
	}
}
