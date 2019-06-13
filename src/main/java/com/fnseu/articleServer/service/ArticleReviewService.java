package com.fnseu.articleServer.service;

import com.fnseu.articleServer.pojo.ArticleReviewInfo;
import com.fnseu.articleServer.pojo.Review;
import com.fnseu.articleServer.pojo.User;

import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/6/12 20:23
 */
public interface ArticleReviewService {
    User selById(Long id);
    List<User> selByName(String name);

    Review selReviewById(Long id);

    List<Review> listReview();

    List<ArticleReviewInfo> listArticleReview(Integer status);

    int addReview(Review revData);
}
