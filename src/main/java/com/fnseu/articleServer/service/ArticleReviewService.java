package com.fnseu.articleServer.service;

import com.fnseu.articleServer.pojo.PageInfo;
import com.fnseu.articleServer.pojo.Review;
import com.fnseu.articleServer.pojo.User;

import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/6/12 20:23
 */
public interface ArticleReviewService {
    PageInfo selArticleReviews(Integer status,Integer pageNum,Integer pageSize);

    int insReview(Review review);
    //ArticleInfo selArticleInfoById(Long id);

    int updStatus(Integer status,Long articleId);
}
