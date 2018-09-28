package com.songhaozhi.mayday.model.domain;

public class Attachment {
    private Integer id;

    private String pictureName;

    private String picturePath;

    private String pictureSmallPath;

    private String pictureType;

    private String pictureCreateDate;

    private String pictureSize;

    private String pictureSuffix;

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

    public String getPictureCreateDate() {
        return pictureCreateDate;
    }

    public void setPictureCreateDate(String pictureCreateDate) {
        this.pictureCreateDate = pictureCreateDate == null ? null : pictureCreateDate.trim();
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