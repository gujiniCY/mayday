package com.songhaozhi.mayday.model.enums;
/**
* @author 宋浩志
* @createDate 创建时间：2019年1月9日 下午10:17:03
* 
*/
public enum ThemeStatus {
	/**
	 * 0 未启用
	 */
	THEME_NOT_ENABLED(0),

	/**
	 * 1 已启用
	 */
	THEME_ENABLED(1);

	private int value;

	private ThemeStatus(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
