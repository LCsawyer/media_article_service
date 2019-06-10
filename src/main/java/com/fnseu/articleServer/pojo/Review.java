package com.fnseu.articleServer.pojo;

import java.math.BigInteger;
import java.sql.Timestamp;

public class Review {
    private long reviewId;
    private long reviewerId;
    private long contentId;
    private int contentType;
    private int level;
    private int result;
    private Timestamp reviewTime;
    private String description;

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", reviewerId=" + reviewerId +
                ", contentId=" + contentId +
                ", contentType=" + contentType +
                ", level=" + level +
                ", result=" + result +
                ", reviewTime=" + reviewTime +
                ", description='" + description + '\'' +
                '}';
    }

    public long getReviewId() {
        return reviewId;
    }

    public void setReviewId(long reviewId) {
        this.reviewId = reviewId;
    }

    public long getReviewerId() {
        return reviewerId;
    }

    public void setReviewerId(long reviewerId) {
        this.reviewerId = reviewerId;
    }

    public long getContentId() {
        return contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public Timestamp getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Timestamp reviewTime) {
        this.reviewTime = reviewTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}