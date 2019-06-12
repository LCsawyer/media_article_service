package com.fnseu.articleServer.service.impl;

import com.fnseu.articleServer.mapper.UserServiceMapper;
import com.fnseu.articleServer.pojo.Article;
import com.fnseu.articleServer.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserServiceMapper userServiceMapper;

    @Override
    public Article selById(int id) {
        return userServiceMapper.selById(id);
    }

    @Override
    public int delById(int id){

        return   userServiceMapper.delById(id);

    }

    @Override
    public List<Article> ListArticle() {
        return userServiceMapper.ListArticle();
    }

    @Override
    public int saveArticle(Article article){
        return userServiceMapper.saveArticle(article);
    }

    @Override
    public int updateArticle(Article article){ return userServiceMapper.updateArticle(article);}
}
