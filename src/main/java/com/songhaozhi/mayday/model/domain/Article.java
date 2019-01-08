package com.songhaozhi.mayday.model.domain;

import java.util.Date;

public class Article {
	private Integer id;

	private Integer userId;

	private String articleContent;

	private String articleContentMd;

	private Date articleNewstime;

	private Integer articleStatus;

	private String articleSummary;

	private String articleThumbnail;

	private String articleTitle;

	private Integer articleType;

	private String articlePost;

	private Integer articleComment;

	private Date articleUpdatetime;

	private String articleUrl;

	private Long articleViews;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent == null ? null : articleContent.trim();
	}

	public String getArticleContentMd() {
		return articleContentMd;
	}

	public void setArticleContentMd(String articleContentMd) {
		this.articleContentMd = articleContentMd == null ? null : articleContentMd.trim();
	}

	public Date getArticleNewstime() {
		return articleNewstime;
	}

	public void setArticleNewstime(Date articleNewstime) {
		this.articleNewstime = articleNewstime;
	}

	public Integer getArticleStatus() {
		return articleStatus;
	}

	public void setArticleStatus(Integer articleStatus) {
		this.articleStatus = articleStatus;
	}

	public String getArticleSummary() {
		return articleSummary;
	}

	public void setArticleSummary(String articleSummary) {
		this.articleSummary = articleSummary == null ? null : articleSummary.trim();
	}

	public String getArticleThumbnail() {
		return articleThumbnail;
	}

	public void setArticleThumbnail(String articleThumbnail) {
		this.articleThumbnail = articleThumbnail == null ? null : articleThumbnail.trim();
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle == null ? null : articleTitle.trim();
	}

	public Integer getArticleType() {
		return articleType;
	}

	public void setArticleType(Integer articleType) {
		this.articleType = articleType;
	}

	public String getArticlePost() {
		return articlePost;
	}

	public void setArticlePost(String articlePost) {
		this.articlePost = articlePost == null ? null : articlePost.trim();
	}

	public Integer getArticleComment() {
		return articleComment;
	}

	public void setArticleComment(Integer articleComment) {
		this.articleComment = articleComment;
	}

	public Date getArticleUpdatetime() {
		return articleUpdatetime;
	}

	public void setArticleUpdatetime(Date articleUpdatetime) {
		this.articleUpdatetime = articleUpdatetime;
	}

	public String getArticleUrl() {
		return articleUrl;
	}

	public void setArticleUrl(String articleUrl) {
		this.articleUrl = articleUrl == null ? null : articleUrl.trim();
	}

	public Long getArticleViews() {
		return articleViews;
	}

	public void setArticleViews(Long articleViews) {
		this.articleViews = articleViews;
	}
}