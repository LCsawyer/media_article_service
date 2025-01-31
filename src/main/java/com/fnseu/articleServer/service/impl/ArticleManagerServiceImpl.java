package com.fnseu.articleServer.service.impl;

import com.fnseu.articleServer.mapper.ArticleManagerMapper;
import com.fnseu.articleServer.pojo.Article;
import com.fnseu.articleServer.pojo.ArticleInfo;
import com.fnseu.articleServer.pojo.PageInfo;
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
    public Article selById(Long id,Integer version) {
        return articleManagerMapper.selById(id,version);
    }

    @Override
    public int delById(Long id,Integer version){
        return  articleManagerMapper.delById(id,version);

    }


    @Override
    public int saveArticle(Article article){
        return articleManagerMapper.saveArticle(article);
    }

    @Override
    public int updateArticle(Article article){ return articleManagerMapper.updateArticle(article);}

    @Override
    public PageInfo selArticleList(Long authorId, Integer status, Integer pageNum, Integer pageSize) {
        PageInfo pageInfo = new PageInfo();
        int count = articleManagerMapper.selCount(authorId,status);
        if (count<=0){
            return null;
        }
        List<ArticleInfo> list = articleManagerMapper.selListArticle(authorId,status,(pageNum-1)*pageSize,pageSize);
        if (list==null || list.size()==0){
            return null;
        }
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
        pageInfo.setPageStart((pageNum-1)*pageSize);
        pageInfo.setList(list);
        return pageInfo;
    }

    @Override
    public Long selAuthorId(Long id) {
        return articleManagerMapper.selUserIdByCountId(id);
    }

    @Override
    public int insArticle(Article article) {
        return articleManagerMapper.insArticle(article);
    }

    @Override
    public int updStatus(Long id, Integer status, Integer version) {
        return articleManagerMapper.updStatus(id,status,version);
    }

    @Override
    public int selStatus(Long id, Integer version) {
        return articleManagerMapper.selStatus(id,version);
    }
}
