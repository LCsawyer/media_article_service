package com.fnseu.articleServer.service;

import com.fnseu.articleServer.pojo.ArticleInfo;
import com.fnseu.articleServer.pojo.ArticleReviewInfo;
import com.fnseu.articleServer.pojo.Review;
import com.fnseu.articleServer.pojo.User;

import java.math.BigInteger;
import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/5/30 16:29
 */
public interface UserService {

    User selById(int id);
    List<User> selByName(String name);

    Review selReviewById(long id);

    List<Review> listReview();

    List<ArticleReviewInfo> listArticleReview(int status);

    String addReview(Review revData);
}
