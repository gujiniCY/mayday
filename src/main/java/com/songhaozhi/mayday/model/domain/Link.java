package com.songhaozhi.mayday.model.domain;

import java.io.Serializable;

public class Link implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7276479736857958686L;

	private Integer linkId;

	private String linkName;

	private String linkUrl;

	private String linkLogo;

	private String linkDescribe;

	public Integer getLinkId() {
		return linkId;
	}

	public void setLinkId(Integer linkId) {
		this.linkId = linkId;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName == null ? null : linkName.trim();
	}

	public String getLinkUrl() {
		return linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl == null ? null : linkUrl.trim();
	}

	public String getLinkLogo() {
		return linkLogo;
	}

	public void setLinkLogo(String linkLogo) {
		this.linkLogo = linkLogo == null ? null : linkLogo.trim();
	}

	public String getLinkDescribe() {
		return linkDescribe;
	}

	public void setLinkDescribe(String linkDescribe) {
		this.linkDescribe = linkDescribe == null ? null : linkDescribe.trim();
	}
}