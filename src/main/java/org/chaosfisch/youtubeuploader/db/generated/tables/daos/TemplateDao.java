/**
 * This class is generated by jOOQ
 */
package org.chaosfisch.youtubeuploader.db.generated.tables.daos;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "3.0.0"},
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked" })
public class TemplateDao extends org.jooq.impl.DAOImpl<org.chaosfisch.youtubeuploader.db.generated.tables.records.TemplateRecord, org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template, java.lang.Integer> {

	/**
	 * Create a new TemplateDao without any configuration
	 */
	public TemplateDao() {
		super(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE, org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template.class);
	}

	/**
	 * Create a new TemplateDao with an attached configuration
	 */
	public TemplateDao(org.jooq.Configuration configuration) {
		super(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE, org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template.class, configuration);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected java.lang.Integer getId(org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template object) {
		return object.getId();
	}

	/**
	 * Fetch records that have <code>ID IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchById(java.lang.Integer... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.ID, values);
	}

	/**
	 * Fetch a unique record that has <code>ID = value</code>
	 */
	public org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template fetchOneById(java.lang.Integer value) {
		return fetchOne(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.ID, value);
	}

	/**
	 * Fetch records that have <code>CATEGORY IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByCategory(org.chaosfisch.youtubeuploader.db.data.Category... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.CATEGORY, values);
	}

	/**
	 * Fetch records that have <code>COMMENT IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByComment(org.chaosfisch.youtubeuploader.db.data.Comment... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.COMMENT, values);
	}

	/**
	 * Fetch records that have <code>COMMENTVOTE IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByCommentvote(java.lang.Boolean... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.COMMENTVOTE, values);
	}

	/**
	 * Fetch records that have <code>DEFAULTDIR IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByDefaultdir(java.io.File... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.DEFAULTDIR, values);
	}

	/**
	 * Fetch records that have <code>DESCRIPTION IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByDescription(java.lang.String... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.DESCRIPTION, values);
	}

	/**
	 * Fetch records that have <code>EMBED IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByEmbed(java.lang.Boolean... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.EMBED, values);
	}

	/**
	 * Fetch records that have <code>KEYWORDS IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByKeywords(java.lang.String... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.KEYWORDS, values);
	}

	/**
	 * Fetch records that have <code>MOBILE IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByMobile(java.lang.Boolean... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.MOBILE, values);
	}

	/**
	 * Fetch records that have <code>NAME IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByName(java.lang.String... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.NAME, values);
	}

	/**
	 * Fetch records that have <code>NUMBER IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByNumber(java.lang.Short... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.NUMBER, values);
	}

	/**
	 * Fetch records that have <code>RATE IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByRate(java.lang.Boolean... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.RATE, values);
	}

	/**
	 * Fetch records that have <code>VIDEORESPONSE IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByVideoresponse(org.chaosfisch.youtubeuploader.db.data.Videoresponse... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.VIDEORESPONSE, values);
	}

	/**
	 * Fetch records that have <code>VISIBILITY IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByVisibility(org.chaosfisch.youtubeuploader.db.data.Visibility... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.VISIBILITY, values);
	}

	/**
	 * Fetch records that have <code>ACCOUNT_ID IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByAccountId(java.lang.Integer... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.ACCOUNT_ID, values);
	}

	/**
	 * Fetch records that have <code>ENDDIR IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByEnddir(java.io.File... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.ENDDIR, values);
	}

	/**
	 * Fetch records that have <code>LICENSE IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByLicense(org.chaosfisch.youtubeuploader.db.data.License... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.LICENSE, values);
	}

	/**
	 * Fetch records that have <code>TITLE IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByTitle(java.lang.String... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.TITLE, values);
	}

	/**
	 * Fetch records that have <code>THUMBNAIL IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByThumbnail(java.lang.String... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.THUMBNAIL, values);
	}

	/**
	 * Fetch records that have <code>FACEBOOK IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByFacebook(java.lang.Boolean... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.FACEBOOK, values);
	}

	/**
	 * Fetch records that have <code>TWITTER IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByTwitter(java.lang.Boolean... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.TWITTER, values);
	}

	/**
	 * Fetch records that have <code>MESSAGE IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByMessage(java.lang.String... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.MESSAGE, values);
	}

	/**
	 * Fetch records that have <code>MONETIZE_INSTREAM_DEFAULTS IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByMonetizeInstreamDefaults(java.lang.Boolean... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.MONETIZE_INSTREAM_DEFAULTS, values);
	}

	/**
	 * Fetch records that have <code>MONETIZE_CLAIM IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByMonetizeClaim(java.lang.Boolean... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.MONETIZE_CLAIM, values);
	}

	/**
	 * Fetch records that have <code>MONETIZE_OVERLAY IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByMonetizeOverlay(java.lang.Boolean... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.MONETIZE_OVERLAY, values);
	}

	/**
	 * Fetch records that have <code>MONETIZE_TRUEVIEW IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByMonetizeTrueview(java.lang.Boolean... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.MONETIZE_TRUEVIEW, values);
	}

	/**
	 * Fetch records that have <code>MONETIZE_INSTREAM IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByMonetizeInstream(java.lang.Boolean... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.MONETIZE_INSTREAM, values);
	}

	/**
	 * Fetch records that have <code>MONETIZE_PRODUCT IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByMonetizeProduct(java.lang.Boolean... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.MONETIZE_PRODUCT, values);
	}

	/**
	 * Fetch records that have <code>MONETIZE_SYNDICATION IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByMonetizeSyndication(org.chaosfisch.youtubeuploader.db.data.Syndication... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.MONETIZE_SYNDICATION, values);
	}

	/**
	 * Fetch records that have <code>MONETIZE_TITLE IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByMonetizeTitle(java.lang.String... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.MONETIZE_TITLE, values);
	}

	/**
	 * Fetch records that have <code>MONETIZE_DESCRIPTION IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByMonetizeDescription(java.lang.String... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.MONETIZE_DESCRIPTION, values);
	}

	/**
	 * Fetch records that have <code>MONETIZE_ID IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByMonetizeId(java.lang.String... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.MONETIZE_ID, values);
	}

	/**
	 * Fetch records that have <code>MONETIZE_NOTES IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByMonetizeNotes(java.lang.String... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.MONETIZE_NOTES, values);
	}

	/**
	 * Fetch records that have <code>MONETIZE_TMSID IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByMonetizeTmsid(java.lang.String... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.MONETIZE_TMSID, values);
	}

	/**
	 * Fetch records that have <code>MONETIZE_ISAN IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByMonetizeIsan(java.lang.String... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.MONETIZE_ISAN, values);
	}

	/**
	 * Fetch records that have <code>MONETIZE_EIDR IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByMonetizeEidr(java.lang.String... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.MONETIZE_EIDR, values);
	}

	/**
	 * Fetch records that have <code>MONETIZE_TITLEEPISODE IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByMonetizeTitleepisode(java.lang.String... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.MONETIZE_TITLEEPISODE, values);
	}

	/**
	 * Fetch records that have <code>MONETIZE_SEASON_NB IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByMonetizeSeasonNb(java.lang.String... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.MONETIZE_SEASON_NB, values);
	}

	/**
	 * Fetch records that have <code>MONETIZE_EPISODE_NB IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByMonetizeEpisodeNb(java.lang.String... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.MONETIZE_EPISODE_NB, values);
	}

	/**
	 * Fetch records that have <code>MONETIZE_CLAIMTYPE IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByMonetizeClaimtype(org.chaosfisch.youtubeuploader.db.data.ClaimType... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.MONETIZE_CLAIMTYPE, values);
	}

	/**
	 * Fetch records that have <code>MONETIZE_CLAIMOPTION IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByMonetizeClaimoption(org.chaosfisch.youtubeuploader.db.data.ClaimOption... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.MONETIZE_CLAIMOPTION, values);
	}

	/**
	 * Fetch records that have <code>MONETIZE_ASSET IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByMonetizeAsset(org.chaosfisch.youtubeuploader.db.data.Asset... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.MONETIZE_ASSET, values);
	}

	/**
	 * Fetch records that have <code>MONETIZE_PARTNER IN (values)</code>
	 */
	public java.util.List<org.chaosfisch.youtubeuploader.db.generated.tables.pojos.Template> fetchByMonetizePartner(java.lang.Boolean... values) {
		return fetch(org.chaosfisch.youtubeuploader.db.generated.tables.Template.TEMPLATE.MONETIZE_PARTNER, values);
	}
}
