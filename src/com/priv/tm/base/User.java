package com.priv.tm.base;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用户类xing
 */

public class User {

    private String username;//用户名
    private String password;//密码
    private String realName;//真实姓名
    private String userType;//用户类别
    private String lock;//锁定标志 1正常 0锁定
    private String lastLoginTime;//最后登陆时间

    public User() {
    }

    public User(String username, String lock) {
        this.username = username;
        this.lock = lock;
    }

    public User(String username, String password, String realName, String userType, String lock) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        this.username = username;
        this.password = password;
        this.realName = realName;
        this.userType = userType;
        this.lock = lock;
        this.lastLoginTime = sdf.format(date);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getLock() {
        return lock;
    }

    public void setLock(String lock) {
        this.lock = lock;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String toString() {
        return "User{" +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", userType='" + userType + '\'' +
                ", lock='" + lock + '\'' +
                ", lastLoginTime='" + lastLoginTime + '\'' +
                '}';
    }
}

