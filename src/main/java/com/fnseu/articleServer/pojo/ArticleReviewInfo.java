package com.fnseu.articleServer.pojo;

import java.math.BigInteger;

public class ArticleReviewInfo {

    private BigInteger reviewId;
    private long reviewer_id;
    private ArticleInfo articleInfo;

    public BigInteger getReviewId() {
        return reviewId;
    }

    public void setReviewId(BigInteger reviewId) {
        this.reviewId = reviewId;
    }

    public long getReviewer_id() {
        return reviewer_id;
    }

    public void setReviewer_id(long reviewer_id) {
        this.reviewer_id = reviewer_id;
    }




    public ArticleInfo getArticleInfo() {
        return articleInfo;
    }

    public void setArticleInfo(ArticleInfo articleInfo) {
        this.articleInfo = articleInfo;
    }
}
