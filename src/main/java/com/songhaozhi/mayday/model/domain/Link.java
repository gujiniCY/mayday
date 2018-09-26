package com.songhaozhi.mayday.model.domain;

import java.io.Serializable;

public class Link implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer linkId;
	/**
	 * 网站名称
	 */
    private String linkName;
    /**
     * 路径
     */
    private String linkUrl;
    /**
     * logo
     */
    private String linkLogo;
    /**
     * 描述
     */
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