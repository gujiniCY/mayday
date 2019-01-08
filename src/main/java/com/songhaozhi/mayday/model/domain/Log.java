package com.songhaozhi.mayday.model.domain;

import java.util.Date;

public class Log {
	private Integer logId;

	private String logTitle;

	private String logContent;

	private String logIp;

	private Date logDate;

	public Log() {
		super();
	}

	public Log(String logTitle, String logContent, String logIp, Date logDate) {
		super();
		this.logTitle = logTitle;
		this.logContent = logContent;
		this.logIp = logIp;
		this.logDate = logDate;
	}

	public Integer getLogId() {
		return logId;
	}

	public void setLogId(Integer logId) {
		this.logId = logId;
	}

	public String getLogTitle() {
		return logTitle;
	}

	public void setLogTitle(String logTitle) {
		this.logTitle = logTitle == null ? null : logTitle.trim();
	}

	public String getLogContent() {
		return logContent;
	}

	public void setLogContent(String logContent) {
		this.logContent = logContent == null ? null : logContent.trim();
	}

	public String getLogIp() {
		return logIp;
	}

	public void setLogIp(String logIp) {
		this.logIp = logIp == null ? null : logIp.trim();
	}

	public Date getLogDate() {
		return logDate;
	}

	public void setLogDate(Date logDate) {
		this.logDate = logDate;
	}
}