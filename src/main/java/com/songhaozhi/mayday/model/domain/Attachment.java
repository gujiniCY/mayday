package com.songhaozhi.mayday.model.domain;

import java.io.Serializable;
import java.util.Date;

public class Attachment implements Serializable{
    private Integer userId;
	private String loginEnable;
	private Integer loginError;
	private Date loginLastTime;
	private String userPortrait;
	private String userExplain;
	private String userDisplayName;
	private String userTitle;
	private String userEmail;
	private String userName;
	private String userPwd;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getLoginEnable() {
		return loginEnable;
	}

	public void setLoginEnable(String loginEnable) {
		this.loginEnable = loginEnable == null ? null : loginEnable.trim();
	}

	public Integer getLoginError() {
		return loginError;
	}

	public void setLoginError(Integer loginError) {
		this.loginError = loginError;
	}

	public Date getLoginLastTime() {
		return loginLastTime;
	}

	public void setLoginLastTime(Date loginLastTime) {
		this.loginLastTime = loginLastTime;
	}

	public String getUserPortrait() {
		return userPortrait;
	}

	public void setUserPortrait(String userPortrait) {
		this.userPortrait = userPortrait == null ? null : userPortrait.trim();
	}

	public String getUserExplain() {
		return userExplain;
	}

	public void setUserExplain(String userExplain) {
		this.userExplain = userExplain == null ? null : userExplain.trim();
	}

	public String getUserDisplayName() {
		return userDisplayName;
	}

	public void setUserDisplayName(String userDisplayName) {
		this.userDisplayName = userDisplayName == null ? null : userDisplayName.trim();
	}

	public String getUserTitle() {
		return userTitle;
	}

	public void setUserTitle(String userTitle) {
		this.userTitle = userTitle == null ? null : userTitle.trim();
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail == null ? null : userEmail.trim();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName == null ? null : userName.trim();
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd == null ? null : userPwd.trim();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
     * 略缩�?
     */
    private String pictureSmallPath;
    /**
     * 图片类型
     */
    private String pictureType;
    /**
     * 上传时间
     */
    private String pictureCreateDate;
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