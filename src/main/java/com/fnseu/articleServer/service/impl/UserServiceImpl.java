package com.fnseu.articleServer.service.impl;

import com.fnseu.articleServer.mapper.UserMapper;
import com.fnseu.articleServer.pojo.Authentication;
import com.fnseu.articleServer.service.UserService;
import com.fnseu.articleServer.pojo.User;
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
    private UserMapper userMapper;//DAO 层

    //根据编号查询
    @Override
    public User selById(Long id) {
        return userMapper.selById(id);
    }

    @Override
    public List<User> selByName(String name) {
        return null;
    }

    @Override
    public List<Authentication> selAuthticationList(Long reviewer_id, Integer STATUS, Integer capacity, Integer offset){
        return userMapper.selAuthticationList(reviewer_id,STATUS,capacity,offset);
    }

    @Override
    public Authentication selectAuthFileById(Long userId){
        return userMapper.selectAuthFileById(userId);
    }

    @Override
    public int insertAuth(Authentication authentication){
        return userMapper.insertAuth(authentication);
    }
}
