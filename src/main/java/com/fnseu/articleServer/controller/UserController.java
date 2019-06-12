package com.fnseu.articleServer.controller;

import com.fnseu.articleServer.pojo.Article;

import com.fnseu.articleServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class UserController {

    @Autowired
    private UserService userService;

    //    @Value("${feign.hystrix.enabled}")
    private String testScope;

    @PostMapping(value="/articles")
    public int saveArticle(Article article){
        return userService.saveArticle(article);
    }
    @GetMapping(value = "/articles/{id}")
    public Article getUser(@PathVariable int id){
        return userService.selById(id);
    }
    @GetMapping("/user/test")
    public String testF(){
        return testScope;
    }
    @GetMapping("/articles")
    public List<Article> ListArticle(){
        return userService.ListArticle();
    }
    @DeleteMapping("/articles/{id}")
    public int deleteUser(@PathVariable int id){
        return userService.delById(id);
    }

    @PutMapping(value="/articles")
    public int updateArticle(Article article){
        return userService.updateArticle(article);
    }
}
