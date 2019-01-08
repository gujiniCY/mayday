package com.songhaozhi.mayday.model.domain;

import java.util.Date;

public class User {
    private Integer userId;

    private String loginEnable;

    private Integer loginError;

    private Date loginLastTime;

    private String userPortrait;

    private String userExplain;

    private String userDisplayName;

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
}