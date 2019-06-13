package com.fnseu.articleServer.pojo;

/**
 * @Author: LiChao
 * @Date: 2019/5/30 16:28
 */
public class User {
    private Long userId;
    private String userName;
    private String pwd;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
