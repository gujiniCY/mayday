package com.songhaozhi.mayday.model.enums;

/**
 * @author : 宋浩志
 * @createDate : 2018年9月19日
 */
public enum MaydayEnums {
	/**
	 * 运行错误
	 */
	ERROR(false, "系统错误"),
	/**
	 * 操作成功
	 */
	OPERATION_SUCCESS(true, "操作成功"),
	/**
	 * 操作错误
	 */
	OPERATION_ERROR(false, "操作失败"),
	/**
	 * 保存成功
	 */
	PRESERVE_SUCCESS(true, "保存成功"),

	DATEBASE_EXECUTION_EXCEPTION(false,"数据库执行语句出现异常"),

	PARAMETER_EXCEPTION(false,"请求参数解析异常"),

	HTTP_REQUEST_METHOD_NOT_SUPPORTED(false,"请求方式错误"),
	/**
	 * 保存失败
	 */
	PRESERVE_ERROR(false, "保存失败");
	private boolean flag;
	private String message;

	private MaydayEnums(boolean flag, String message) {
		this.flag = flag;
		this.message = message;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
