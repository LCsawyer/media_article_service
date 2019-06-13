package com.fnseu.articleServer.service.impl;

import com.fnseu.articleServer.mapper.ArticleManagerMapper;
import com.fnseu.articleServer.pojo.Article;
import com.fnseu.articleServer.service.ArticleManagerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/6/12 19:35
 */
@Service("articleManagerService")
@Transactional
public class ArticleManagerServiceImpl implements ArticleManagerService {
    @Resource
    private ArticleManagerMapper articleManagerMapper;

    @Override
    public Article selById(Long id) {
        return articleManagerMapper.selById(id);
    }

    @Override
    public int delById(Long id){
        return  articleManagerMapper.delById(id);

    }

    @Override
    public List<Article> ListArticle() {
        return articleManagerMapper.ListArticle();
    }

    @Override
    public int saveArticle(Article article){
        return articleManagerMapper.saveArticle(article);
    }

    @Override
    public int updateArticle(Article article){ return articleManagerMapper.updateArticle(article);}
}
