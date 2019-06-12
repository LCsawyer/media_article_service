package com.fnseu.articleServer.controller;


import com.fnseu.articleServer.pojo.ArticleInfo;
import com.fnseu.articleServer.pojo.ArticleReviewInfo;
import com.fnseu.articleServer.pojo.Review;
import com.fnseu.articleServer.pojo.User;
import com.fnseu.articleServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/5/30 16:37
 */
@RestController
//@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

//    @Value("${feign.hystrix.enabled}")
//    private String testScope;

    @GetMapping(value = "/user/{id}")
    public User getUser(@PathVariable int id){
        return userService.selById(id);
    }

    @GetMapping(value = "/review/article/collection_test")
    public List<Review> getArticleReview(@RequestParam int status,
                                         @RequestParam(defaultValue = "10") int size,
                                         @RequestParam(defaultValue = "1")int currentPage){
            return userService.listReview();
    }
    //内容审核列表查询
    @GetMapping(value = "/review/article/collection")
    public List<ArticleReviewInfo> listArticleReview(@RequestParam(defaultValue = "-1") int status,
                                                            @RequestParam(defaultValue = "10") int capcity,
                                                            @RequestParam(defaultValue = "1")int currentPage){
            return userService.listArticleReview(status, capcity, (currentPage-1)*capcity);
    }

    //内容审核详情查询
    @GetMapping(value = "/review/article")
    public Review selReviewById(@RequestParam long id){
        return userService.selReviewById(id);
    }
//    @GetMapping("/user/test")
//    public String testF(){
//        return testScope;
//    }
    //内容审核反馈
    @PostMapping(value = "/review/article/identity")
    public String addArticleReview(@RequestBody Review articleReview){
        return userService.addReview(articleReview);
    }
}
