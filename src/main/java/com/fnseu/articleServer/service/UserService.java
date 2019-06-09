package com.fnseu.articleServer.service;

import com.fnseu.articleServer.pojo.Authentication;
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
    List<Authentication> selAuthticationList(BigInteger reviewer_id, Integer STATUS,Integer capacity, Integer current_page);
    Authentication selectAuthFileById(int userId);
    int insertAuth(Authentication authentication);
}
