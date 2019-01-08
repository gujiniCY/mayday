package com.songhaozhi.mayday.model.domain;

import java.util.Date;

public class Attachment {
	private Integer id;
	/**
	 * 图片名称
	 */
	private String pictureName;
	/**
	 * 图片路径
	 */
	private String picturePath;
	/**
	 * 略缩图
	 */
	private String pictureSmallPath;
	/**
	 * 图片类型
	 */
	private String pictureType;
	/**
	 * 上传时间
	 */
	private Date pictureCreateDate;
	/**
	 * 文件大小
	 */
	private String pictureSize;
	/**
	 * 后缀
	 */
	private String pictureSuffix;
	/**
	 * 尺寸
	 */
	private String pictureWh;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName == null ? null : pictureName.trim();
	}

	public String getPicturePath() {
		return picturePath;
	}

	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath == null ? null : picturePath.trim();
	}

	public String getPictureSmallPath() {
		return pictureSmallPath;
	}

	public void setPictureSmallPath(String pictureSmallPath) {
		this.pictureSmallPath = pictureSmallPath == null ? null : pictureSmallPath.trim();
	}

	public String getPictureType() {
		return pictureType;
	}

	public void setPictureType(String pictureType) {
		this.pictureType = pictureType == null ? null : pictureType.trim();
	}

	public Date getPictureCreateDate() {
		return pictureCreateDate;
	}

	public void setPictureCreateDate(Date pictureCreateDate) {
		this.pictureCreateDate = pictureCreateDate;
	}

	public String getPictureSize() {
		return pictureSize;
	}

	public void setPictureSize(String pictureSize) {
		this.pictureSize = pictureSize == null ? null : pictureSize.trim();
	}

	public String getPictureSuffix() {
		return pictureSuffix;
	}

	public void setPictureSuffix(String pictureSuffix) {
		this.pictureSuffix = pictureSuffix == null ? null : pictureSuffix.trim();
	}

	public String getPictureWh() {
		return pictureWh;
	}

	public void setPictureWh(String pictureWh) {
		this.pictureWh = pictureWh == null ? null : pictureWh.trim();
	}
}