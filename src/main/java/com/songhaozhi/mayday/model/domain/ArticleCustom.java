package com.songhaozhi.mayday.model.domain;
/**
* @author 宋浩志
* @createDate 创建时间：2018年10月30日 下午8:33:14
* 
*/
public class ArticleCustom extends Article{
	private String categorys;
	private String tags;
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
