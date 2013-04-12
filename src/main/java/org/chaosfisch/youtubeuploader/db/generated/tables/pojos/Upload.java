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
package org.chaosfisch.youtubeuploader.db.generated.tables.pojos;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = {"http://www.jooq.org", "3.0.0"},
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked" })
public class Upload extends org.chaosfisch.youtubeuploader.db.AbstractPojo implements java.io.Serializable {

	private static final long serialVersionUID = 2095238776;

	private java.lang.Integer                                    id;
	private java.lang.Boolean                                    archived;
	private org.chaosfisch.youtubeuploader.db.data.Category      category;
	private org.chaosfisch.youtubeuploader.db.data.Comment       comment;
	private java.lang.Boolean                                    commentvote;
	private java.lang.String                                     description;
	private java.lang.Boolean                                    embed;
	private java.lang.Boolean                                    failed;
	private java.io.File                                         file;
	private org.chaosfisch.youtubeuploader.db.data.Visibility    visibility;
	private java.lang.String                                     keywords;
	private java.lang.String                                     mimetype;
	private java.lang.Boolean                                    mobile;
	private java.lang.Boolean                                    rate;
	private java.lang.String                                     title;
	private java.lang.String                                     uploadurl;
	private org.chaosfisch.youtubeuploader.db.data.Videoresponse videoresponse;
	private java.util.GregorianCalendar                          dateOfStart;
	private java.lang.Boolean                                    inprogress;
	private java.lang.Boolean                                    locked;
	private java.lang.String                                     videoid;
	private java.lang.Integer                                    accountId;
	private java.io.File                                         enddir;
	private org.chaosfisch.youtubeuploader.db.data.License       license;
	private java.util.GregorianCalendar                          dateOfRelease;
	private java.lang.Short                                      number;
	private java.lang.Boolean                                    pauseonfinish;
	private java.lang.String                                     thumbnail;
	private java.lang.Boolean                                    facebook;
	private java.lang.Boolean                                    twitter;
	private java.lang.String                                     message;
	private java.lang.Boolean                                    monetizeInstreamDefaults;
	private java.lang.Boolean                                    monetizeClaim;
	private java.lang.Boolean                                    monetizeOverlay;
	private java.lang.Boolean                                    monetizeTrueview;
	private java.lang.Boolean                                    monetizeInstream;
	private java.lang.Boolean                                    monetizeProduct;
	private org.chaosfisch.youtubeuploader.db.data.Syndication   monetizeSyndication;
	private java.lang.String                                     monetizeTitle;
	private java.lang.String                                     monetizeDescription;
	private java.lang.String                                     monetizeId;
	private java.lang.String                                     monetizeNotes;
	private java.lang.String                                     monetizeTmsid;
	private java.lang.String                                     monetizeIsan;
	private java.lang.String                                     monetizeEidr;
	private java.lang.String                                     monetizeTitleepisode;
	private java.lang.String                                     monetizeSeasonNb;
	private java.lang.String                                     monetizeEpisodeNb;
	private org.chaosfisch.youtubeuploader.db.data.ClaimType     monetizeClaimtype;
	private org.chaosfisch.youtubeuploader.db.data.ClaimOption   monetizeClaimoption;
	private org.chaosfisch.youtubeuploader.db.data.Asset         monetizeAsset;
	private java.lang.Boolean                                    monetizePartner;

	public java.lang.Integer getId() {
		return this.id;
	}

	public void setId(java.lang.Integer id) {
		this.id = id;
	}

	public java.lang.Boolean getArchived() {
		return this.archived;
	}

	public void setArchived(java.lang.Boolean archived) {
		this.archived = archived;
	}

	public org.chaosfisch.youtubeuploader.db.data.Category getCategory() {
		return this.category;
	}

	public void setCategory(org.chaosfisch.youtubeuploader.db.data.Category category) {
		this.category = category;
	}

	public org.chaosfisch.youtubeuploader.db.data.Comment getComment() {
		return this.comment;
	}

	public void setComment(org.chaosfisch.youtubeuploader.db.data.Comment comment) {
		this.comment = comment;
	}

	public java.lang.Boolean getCommentvote() {
		return this.commentvote;
	}

	public void setCommentvote(java.lang.Boolean commentvote) {
		this.commentvote = commentvote;
	}

	public java.lang.String getDescription() {
		return this.description;
	}

	public void setDescription(java.lang.String description) {
		this.description = description;
	}

	public java.lang.Boolean getEmbed() {
		return this.embed;
	}

	public void setEmbed(java.lang.Boolean embed) {
		this.embed = embed;
	}

	public java.lang.Boolean getFailed() {
		return this.failed;
	}

	public void setFailed(java.lang.Boolean failed) {
		this.failed = failed;
	}

	public java.io.File getFile() {
		return this.file;
	}

	public void setFile(java.io.File file) {
		this.file = file;
	}

	public org.chaosfisch.youtubeuploader.db.data.Visibility getVisibility() {
		return this.visibility;
	}

	public void setVisibility(org.chaosfisch.youtubeuploader.db.data.Visibility visibility) {
		this.visibility = visibility;
	}

	public java.lang.String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(java.lang.String keywords) {
		this.keywords = keywords;
	}

	public java.lang.String getMimetype() {
		return this.mimetype;
	}

	public void setMimetype(java.lang.String mimetype) {
		this.mimetype = mimetype;
	}

	public java.lang.Boolean getMobile() {
		return this.mobile;
	}

	public void setMobile(java.lang.Boolean mobile) {
		this.mobile = mobile;
	}

	public java.lang.Boolean getRate() {
		return this.rate;
	}

	public void setRate(java.lang.Boolean rate) {
		this.rate = rate;
	}

	public java.lang.String getTitle() {
		return this.title;
	}

	public void setTitle(java.lang.String title) {
		this.title = title;
	}

	public java.lang.String getUploadurl() {
		return this.uploadurl;
	}

	public void setUploadurl(java.lang.String uploadurl) {
		this.uploadurl = uploadurl;
	}

	public org.chaosfisch.youtubeuploader.db.data.Videoresponse getVideoresponse() {
		return this.videoresponse;
	}

	public void setVideoresponse(org.chaosfisch.youtubeuploader.db.data.Videoresponse videoresponse) {
		this.videoresponse = videoresponse;
	}

	public java.util.GregorianCalendar getDateOfStart() {
		return this.dateOfStart;
	}

	public void setDateOfStart(java.util.GregorianCalendar dateOfStart) {
		this.dateOfStart = dateOfStart;
	}

	public java.lang.Boolean getInprogress() {
		return this.inprogress;
	}

	public void setInprogress(java.lang.Boolean inprogress) {
		this.inprogress = inprogress;
	}

	public java.lang.Boolean getLocked() {
		return this.locked;
	}

	public void setLocked(java.lang.Boolean locked) {
		this.locked = locked;
	}

	public java.lang.String getVideoid() {
		return this.videoid;
	}

	public void setVideoid(java.lang.String videoid) {
		this.videoid = videoid;
	}

	public java.lang.Integer getAccountId() {
		return this.accountId;
	}

	public void setAccountId(java.lang.Integer accountId) {
		this.accountId = accountId;
	}

	public java.io.File getEnddir() {
		return this.enddir;
	}

	public void setEnddir(java.io.File enddir) {
		this.enddir = enddir;
	}

	public org.chaosfisch.youtubeuploader.db.data.License getLicense() {
		return this.license;
	}

	public void setLicense(org.chaosfisch.youtubeuploader.db.data.License license) {
		this.license = license;
	}

	public java.util.GregorianCalendar getDateOfRelease() {
		return this.dateOfRelease;
	}

	public void setDateOfRelease(java.util.GregorianCalendar dateOfRelease) {
		this.dateOfRelease = dateOfRelease;
	}

	public java.lang.Short getNumber() {
		return this.number;
	}

	public void setNumber(java.lang.Short number) {
		this.number = number;
	}

	public java.lang.Boolean getPauseonfinish() {
		return this.pauseonfinish;
	}

	public void setPauseonfinish(java.lang.Boolean pauseonfinish) {
		this.pauseonfinish = pauseonfinish;
	}

	public java.lang.String getThumbnail() {
		return this.thumbnail;
	}

	public void setThumbnail(java.lang.String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public java.lang.Boolean getFacebook() {
		return this.facebook;
	}

	public void setFacebook(java.lang.Boolean facebook) {
		this.facebook = facebook;
	}

	public java.lang.Boolean getTwitter() {
		return this.twitter;
	}

	public void setTwitter(java.lang.Boolean twitter) {
		this.twitter = twitter;
	}

	public java.lang.String getMessage() {
		return this.message;
	}

	public void setMessage(java.lang.String message) {
		this.message = message;
	}

	public java.lang.Boolean getMonetizeInstreamDefaults() {
		return this.monetizeInstreamDefaults;
	}

	public void setMonetizeInstreamDefaults(java.lang.Boolean monetizeInstreamDefaults) {
		this.monetizeInstreamDefaults = monetizeInstreamDefaults;
	}

	public java.lang.Boolean getMonetizeClaim() {
		return this.monetizeClaim;
	}

	public void setMonetizeClaim(java.lang.Boolean monetizeClaim) {
		this.monetizeClaim = monetizeClaim;
	}

	public java.lang.Boolean getMonetizeOverlay() {
		return this.monetizeOverlay;
	}

	public void setMonetizeOverlay(java.lang.Boolean monetizeOverlay) {
		this.monetizeOverlay = monetizeOverlay;
	}

	public java.lang.Boolean getMonetizeTrueview() {
		return this.monetizeTrueview;
	}

	public void setMonetizeTrueview(java.lang.Boolean monetizeTrueview) {
		this.monetizeTrueview = monetizeTrueview;
	}

	public java.lang.Boolean getMonetizeInstream() {
		return this.monetizeInstream;
	}

	public void setMonetizeInstream(java.lang.Boolean monetizeInstream) {
		this.monetizeInstream = monetizeInstream;
	}

	public java.lang.Boolean getMonetizeProduct() {
		return this.monetizeProduct;
	}

	public void setMonetizeProduct(java.lang.Boolean monetizeProduct) {
		this.monetizeProduct = monetizeProduct;
	}

	public org.chaosfisch.youtubeuploader.db.data.Syndication getMonetizeSyndication() {
		return this.monetizeSyndication;
	}

	public void setMonetizeSyndication(org.chaosfisch.youtubeuploader.db.data.Syndication monetizeSyndication) {
		this.monetizeSyndication = monetizeSyndication;
	}

	public java.lang.String getMonetizeTitle() {
		return this.monetizeTitle;
	}

	public void setMonetizeTitle(java.lang.String monetizeTitle) {
		this.monetizeTitle = monetizeTitle;
	}

	public java.lang.String getMonetizeDescription() {
		return this.monetizeDescription;
	}

	public void setMonetizeDescription(java.lang.String monetizeDescription) {
		this.monetizeDescription = monetizeDescription;
	}

	public java.lang.String getMonetizeId() {
		return this.monetizeId;
	}

	public void setMonetizeId(java.lang.String monetizeId) {
		this.monetizeId = monetizeId;
	}

	public java.lang.String getMonetizeNotes() {
		return this.monetizeNotes;
	}

	public void setMonetizeNotes(java.lang.String monetizeNotes) {
		this.monetizeNotes = monetizeNotes;
	}

	public java.lang.String getMonetizeTmsid() {
		return this.monetizeTmsid;
	}

	public void setMonetizeTmsid(java.lang.String monetizeTmsid) {
		this.monetizeTmsid = monetizeTmsid;
	}

	public java.lang.String getMonetizeIsan() {
		return this.monetizeIsan;
	}

	public void setMonetizeIsan(java.lang.String monetizeIsan) {
		this.monetizeIsan = monetizeIsan;
	}

	public java.lang.String getMonetizeEidr() {
		return this.monetizeEidr;
	}

	public void setMonetizeEidr(java.lang.String monetizeEidr) {
		this.monetizeEidr = monetizeEidr;
	}

	public java.lang.String getMonetizeTitleepisode() {
		return this.monetizeTitleepisode;
	}

	public void setMonetizeTitleepisode(java.lang.String monetizeTitleepisode) {
		this.monetizeTitleepisode = monetizeTitleepisode;
	}

	public java.lang.String getMonetizeSeasonNb() {
		return this.monetizeSeasonNb;
	}

	public void setMonetizeSeasonNb(java.lang.String monetizeSeasonNb) {
		this.monetizeSeasonNb = monetizeSeasonNb;
	}

	public java.lang.String getMonetizeEpisodeNb() {
		return this.monetizeEpisodeNb;
	}

	public void setMonetizeEpisodeNb(java.lang.String monetizeEpisodeNb) {
		this.monetizeEpisodeNb = monetizeEpisodeNb;
	}

	public org.chaosfisch.youtubeuploader.db.data.ClaimType getMonetizeClaimtype() {
		return this.monetizeClaimtype;
	}

	public void setMonetizeClaimtype(org.chaosfisch.youtubeuploader.db.data.ClaimType monetizeClaimtype) {
		this.monetizeClaimtype = monetizeClaimtype;
	}

	public org.chaosfisch.youtubeuploader.db.data.ClaimOption getMonetizeClaimoption() {
		return this.monetizeClaimoption;
	}

	public void setMonetizeClaimoption(org.chaosfisch.youtubeuploader.db.data.ClaimOption monetizeClaimoption) {
		this.monetizeClaimoption = monetizeClaimoption;
	}

	public org.chaosfisch.youtubeuploader.db.data.Asset getMonetizeAsset() {
		return this.monetizeAsset;
	}

	public void setMonetizeAsset(org.chaosfisch.youtubeuploader.db.data.Asset monetizeAsset) {
		this.monetizeAsset = monetizeAsset;
	}

	public java.lang.Boolean getMonetizePartner() {
		return this.monetizePartner;
	}

	public void setMonetizePartner(java.lang.Boolean monetizePartner) {
		this.monetizePartner = monetizePartner;
	}
}
