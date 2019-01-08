package com.songhaozhi.mayday.model.domain;

import java.io.Serializable;

public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1660254568965065323L;

	private Integer categoryId;

	private String categoryName;

	private String categoryUrl;

	private String categoryDescribe;

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName == null ? null : categoryName.trim();
	}

	public String getCategoryUrl() {
		return categoryUrl;
	}

	public void setCategoryUrl(String categoryUrl) {
		this.categoryUrl = categoryUrl == null ? null : categoryUrl.trim();
	}

	public String getCategoryDescribe() {
		return categoryDescribe;
	}

	public void setCategoryDescribe(String categoryDescribe) {
		this.categoryDescribe = categoryDescribe == null ? null : categoryDescribe.trim();
	}
}