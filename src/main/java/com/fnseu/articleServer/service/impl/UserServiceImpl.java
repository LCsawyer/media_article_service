package com.fnseu.articleServer.service.impl;

import com.fnseu.articleServer.mapper.UserServiceMapper;
import com.fnseu.articleServer.service.UserService;
import com.fnseu.articleServer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/5/30 16:31
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserServiceMapper userServiceMapper;

    @Override
    public User selById(int id) {
        return userServiceMapper.selById(id);
    }

    @Override
    public List<User> selByName(String name) {
        return null;
    }
}
