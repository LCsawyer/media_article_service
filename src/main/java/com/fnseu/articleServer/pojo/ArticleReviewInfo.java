package com.fnseu.articleServer.pojo;

/**
 * @Author: LiChao
 * @Date: 2019/6/12 19:21
 */
public class ArticleReviewInfo {
    private Long reviewId;
    private long reviewerId;
    private ArticleInfo articleInfo;

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public ArticleInfo getArticleInfo() {
        return articleInfo;
    }

    public void setArticleInfo(ArticleInfo articleInfo) {
        this.articleInfo = articleInfo;
    }
}
