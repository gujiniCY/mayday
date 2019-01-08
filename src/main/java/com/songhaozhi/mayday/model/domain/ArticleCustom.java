package com.songhaozhi.mayday.model.domain;

/**
 * @author 宋浩志
 * @createDate 创建时间：2018年10月30日 下午8:33:14
 * 
 */
public class ArticleCustom extends Article {
	// 分类id
	private String categorys;
	// 标签id
	private String tags;
	// 分类名称
	private String categorysName;
	// 标签名称
	private String tagsName;
	// 分类路径
	private String categorysUrl;
	// 标签路径
	private String tagsUrl;

	public String getCategorysName() {
		return categorysName;
	}

	public void setCategorysName(String categorysName) {
		this.categorysName = categorysName;
	}

	public String getTagsName() {
		return tagsName;
	}

	public void setTagsName(String tagsName) {
		this.tagsName = tagsName;
	}

	public String getCategorysUrl() {
		return categorysUrl;
	}

	public void setCategorysUrl(String categorysUrl) {
		this.categorysUrl = categorysUrl;
	}

	public String getTagsUrl() {
		return tagsUrl;
	}

	public void setTagsUrl(String tagsUrl) {
		this.tagsUrl = tagsUrl;
	}

	public String getCategorys() {
		return categorys;
	}

	public void setCategorys(String categorys) {
		this.categorys = categorys;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

}
