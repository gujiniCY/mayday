package com.songhaozhi.mayday.model.enums;
/**
* @author 作者:宋浩志
* @createDate 创建时间：2018年9月19日 下午2:45:51
*/
public enum MaydayEnums {
	/**
	 * 操作成功
	 */
	OPERATION_SUCCESS(200, "操作成功！"),
	/**
	 * 操作失败
	 */
	OPERATION_ERROR(500,"操作失败"),
	
	/**
	 * 保存成功
	 */
	PRESERVE_SUCCESS(200,"保存成功"),
	/**
	 * 保存失败
	 */
	PRESERVE_ERROR(500,"保存失败");
	private Integer code;
    private String message;
    
	private MaydayEnums(Integer code, String message) {
		this.code = code;
		this.message = message;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

    
}
