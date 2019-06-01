package com.fnseu.articleServer.service;

import com.fnseu.articleServer.pojo.User;

import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/5/30 16:29
 */
public interface UserService {
    User selById(int id);
    List<User> selByName(String name);
}
