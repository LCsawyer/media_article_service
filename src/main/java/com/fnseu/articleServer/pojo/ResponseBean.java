package com.fnseu.articleServer.pojo;

/**
 * @Author: LiChao
 * @Date: 2019/6/17 22:16
 */
public class ResponseBean<T> {
    private int httpCode;
    private boolean isSuccess;
    private String msg;
    private T data;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public ResponseBean(int httpCode, boolean isSuccess,String msg, T data) {
        this.httpCode = httpCode;
        this.msg = msg;
        this.data = data;
        this.isSuccess = isSuccess;
    }

    public int getHttpCode() {
        return httpCode;
    }

    public void setHttpCode(int httpCode) {
        this.httpCode = httpCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
