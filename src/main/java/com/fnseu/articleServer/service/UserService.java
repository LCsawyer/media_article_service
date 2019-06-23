package com.fnseu.articleServer.service;

import com.fnseu.articleServer.pojo.AuthReviewInfo;
import com.fnseu.articleServer.pojo.Authentication;
import com.fnseu.articleServer.pojo.PageInfo;
import com.fnseu.articleServer.pojo.User;

import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/5/30 16:29
 */
public interface UserService {
    User selById(Long id);
    List<User> selByName(String name);
    PageInfo selAuthticationList(Long reviewer_id, Integer STATUS, Integer pageNum, Integer pageSize);
    Authentication selectAuthFileById(Long userId);
    int insertAuth(Authentication authentication);
    int updAuthReview(AuthReviewInfo authReviewInfo);
}
