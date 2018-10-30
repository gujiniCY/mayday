package com.songhaozhi.mayday.model.enums;

/**
 * @author 作者:宋浩志
 * @createDate 创建时间：2018年10月30日 下午3:52:12
 */
public enum PostType {
	/**
	 * 文章
	 */
	POST_TYPE_POST("post"),

	/**
	 * 页面
	 */
	POST_TYPE_PAGE("page");

	private String value;

	private PostType(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
