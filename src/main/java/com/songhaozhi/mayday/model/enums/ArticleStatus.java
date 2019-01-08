package com.songhaozhi.mayday.model.enums;

/**
 * @author : 宋浩志
 * @createDate : 2018年11月4日 文章状态
 */
public enum ArticleStatus {
	/**
	 * 已发布
	 */
	PUBLISH(0, "已发布"),
	/**
	 * 草稿
	 */
	DRAFT(1, "草稿"),
	/**
	 * 回收站
	 */
	RECYCLE(2, "回收站");

	private Integer status;
	private String desc;

	private ArticleStatus(Integer status, String desc) {
		this.status = status;
		this.desc = desc;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
