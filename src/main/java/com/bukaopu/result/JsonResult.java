package com.bukaopu.result;

/**
 * @author 作者:宋浩志
 * @createDate 创建时间：2018年8月27日 下午1:38:27
 */
public class JsonResult {
	private static final int SUCCESS = 0;
	private boolean flag;
	private int code;
	private String msg;
	private Object data;

	public JsonResult() {
		this.flag = true;
		this.code = SUCCESS;
		this.msg = "成功";
	}
	public JsonResult(Object data) {
		this.flag = true;
		this.code = SUCCESS;
		this.msg = "成功";
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
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
