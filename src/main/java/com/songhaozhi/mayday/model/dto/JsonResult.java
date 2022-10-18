package com.songhaozhi.mayday.model.dto;

import com.songhaozhi.mayday.model.enums.MaydayEnums;

/**
 * @author : 宋浩志
 * @createDate : 2018年8月27日
 */
public class JsonResult {
	public static final boolean SUCCESS = true;
	public static final boolean ERROR = false;

	private boolean flag;
	private String msg;
	private Object data;

	public JsonResult() {
		super();
	}

	public JsonResult(boolean flag, String msg) {
		super();
		this.flag = flag;
		this.msg = msg;
	}

	public JsonResult(boolean flag, String msg, Object data) {
		super();
		this.flag = flag;
		this.msg = msg;
		this.data = data;
	}

	public static JsonResult result(boolean flag) {
		if (flag) {
			return ok();
		}
		return fail("");
	}
	public static JsonResult ok() {
		return ok( null );
	}
	public static JsonResult ok(String msg) {
		return result(SUCCESS, msg);
	}

	public static JsonResult result(boolean flag, String msg) {
		return new JsonResult(flag, msg);
	}
	public static JsonResult result(MaydayEnums maydayEnums) {
		return new JsonResult(maydayEnums.isFlag(), maydayEnums.getMessage());
	}

	public static JsonResult fail(String msg) {
		return result(ERROR, msg);
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
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
