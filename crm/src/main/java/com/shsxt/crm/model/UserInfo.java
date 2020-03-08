package com.shsxt.crm.model;

/**
 * Created by 15625 on 2020/1/28.
 */
public class UserInfo {
    private String userIdStr;   //ID的加密字符串

    public UserInfo() {
    }

    public UserInfo(String userIdStr) {
        this.userIdStr = userIdStr;
    }

    public String getUserIdStr() {
        return userIdStr;
    }

    public void setUserIdStr(String userIdStr) {
        this.userIdStr = userIdStr;
    }
}
