package com.fnseu.articleServer.service.impl;

import com.fnseu.articleServer.mapper.UserServiceMapper;
import com.fnseu.articleServer.pojo.Authentication;
import com.fnseu.articleServer.pojo.User;
import com.fnseu.articleServer.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/5/30 16:31
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserServiceMapper userServiceMapper;//DAO 层

//根据编号查询
    @Override
    public User selById(int id) {
        return userServiceMapper.selById(id);
    }

    @Override
    public List<User> selByName(String name) {
        return null;
    }

    @Override
    public List<Authentication> selAuthticationList(BigInteger reviewer_id, Integer STATUS,Integer capacity, Integer offset){
        return userServiceMapper.selAuthticationList(reviewer_id,STATUS,capacity,offset);
    }

    @Override
    public Authentication selectAuthFileById(int userId){
        return userServiceMapper.selectAuthFileById(userId);
    }

    @Override
    public int insertAuth(Authentication authentication){
        return userServiceMapper.insertAuth(authentication);
    }
}
