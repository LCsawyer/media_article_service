package com.fnseu.articleServer.pojo;

import javax.xml.soap.Text;
import java.math.BigInteger;

public class ArticleInfo {
    private BigInteger articleId;

    private int status; //审核结果
    private String title;
    private BigInteger author_id;
    //private String version;
//    private BigInteger author_id;
//    private Text body;
//    private String abstr;
//    private String keywords;
//    private String entities;
//    private int level;
//    private String source;
//    private String category;
//    private String subcategory;
    public BigInteger getArticleId() {
        return articleId;
    }

    public void setArticleId(BigInteger articleId) {
        this.articleId = articleId;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigInteger getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(BigInteger author_id) {
        this.author_id = author_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
