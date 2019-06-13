package com.fnseu.articleServer.service;

import com.fnseu.articleServer.pojo.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/6/12 19:32
 */

public interface ArticleManagerService {
    Article selById(Long id);
    int delById(Long id);
    List<Article> ListArticle();
    int saveArticle(Article article);
    int updateArticle(Article article);
}
