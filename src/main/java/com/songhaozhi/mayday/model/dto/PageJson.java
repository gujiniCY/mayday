package com.songhaozhi.mayday.model.dto;

import java.util.List;


/**
 * @author : 宋浩志
 * @createDate : 2018年10月30日
 * 
 */
public class PageJson {
	private Long total;
	private List rows;

	public PageJson() {
	}

	public PageJson(Long total, List rows) {
		this.total = total;
		this.rows = rows;
	}
}
