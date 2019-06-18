package com.fnseu.articleServer.pojo;

/**
 * @Author: LiChao
 * @Date: 2019/6/18 14:35
 */
public class ArticleInfo {
    private Long id;
    private String title;
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
