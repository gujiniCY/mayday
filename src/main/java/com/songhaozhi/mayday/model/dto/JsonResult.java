package com.songhaozhi.mayday.model.dto;

/**
 * @author 作者:宋浩志
 * @createDate 创建时间：2018年8月27日 下午1:38:27
 */
public class JsonResult {
	private boolean flag;
	private String code;
	private String msg;
	private Object data;

	public JsonResult(boolean flag, String code, String msg) {
		this.flag = flag;
		this.code = code;
		this.msg = msg;
	}

	public JsonResult(boolean flag, String code, String msg, Object data) {
		this.flag = flag;
		this.code = code;
		this.msg = msg;
		this.data = data;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
