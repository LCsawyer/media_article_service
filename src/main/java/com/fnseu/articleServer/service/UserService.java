package com.fnseu.articleServer.service;

import com.fnseu.articleServer.pojo.Article;

import java.util.List;


public interface UserService {

    Article selById(int id);
    int delById(int id);
    List<Article> ListArticle();
    int saveArticle(Article article);
    int updateArticle(Article article);
}
