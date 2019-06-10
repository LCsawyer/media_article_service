package com.fnseu.articleServer.pojo;

import java.math.BigInteger;
import java.sql.Timestamp;

public class Review {
    private BigInteger reviewId;
    private long reviewer_id;
    private BigInteger contentId;
    private Integer content_type;
    private Integer level;
    private Integer result;
    private Timestamp reviewTime;
    private String description;

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

    public BigInteger getContentId() {
        return contentId;
    }

    public void setContentId(BigInteger contentId) {
        this.contentId = contentId;
    }

    public Integer getContent_type() {
        return content_type;
    }

    public void setContent_type(Integer content_type) {
        this.content_type = content_type;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getReviewTime() {
        return reviewTime.toString();
    }

    public void setReviewTime(Timestamp reviewTime) {
        this.reviewTime = reviewTime;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", reviewer_id=" + reviewer_id +
                ", contentId=" + contentId +
                ", content_type=" + content_type +
                ", level=" + level +
                ", result=" + result +
                ", reviewTime=" + reviewTime +
                ", description='" + description + '\'' +
                '}';
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
