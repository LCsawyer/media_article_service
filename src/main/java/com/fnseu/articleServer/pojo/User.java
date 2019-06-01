package com.fnseu.articleServer.pojo;

/**
 * @Author: LiChao
 * @Date: 2019/5/30 16:28
 */
public class User {
    private int userId;
    private String userName;
    private String pwd;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
