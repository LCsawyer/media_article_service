package com.fnseu.articleServer.pojo;

/**
 * @Author: LiChao
 * @Date: 2019/6/17 22:16
 */
public class ResponseBean<T> {
    private int httpCode;
    private String msg;
    private T data;

    public ResponseBean(int httpCode, String msg, T data) {
        this.httpCode = httpCode;
        this.msg = msg;
        this.data = data;
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
