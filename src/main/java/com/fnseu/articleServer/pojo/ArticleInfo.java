package com.fnseu.articleServer.pojo;

import javax.xml.soap.Text;
import java.math.BigInteger;

public class ArticleInfo {
    private long articleId;

    private int status; //审核结果
    private String title;
    private long authorId;
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

    public long getArticleId() {
        return articleId;
    }

    public void setArticleId(long articleId) {
        this.articleId = articleId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(long authorId) {
        this.authorId = authorId;
    }
}
