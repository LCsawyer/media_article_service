package com.fnseu.articleServer.service;

import com.fnseu.articleServer.pojo.Article;
import com.fnseu.articleServer.pojo.PageInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/6/12 19:32
 */

public interface ArticleManagerService {
    Article selById(Long id);
    int delById(Long id);
    int saveArticle(Article article);
    int updateArticle(Article article);
    PageInfo selArticleList(Long articleId,Integer status,Integer pageNum,Integer pageSize);
    Long selAuthorId(Long id);
    int insArticle(Article article);
    int updStatus(Long id,Integer status,Integer version);
    int selStatus(Long id,Integer version);
}
