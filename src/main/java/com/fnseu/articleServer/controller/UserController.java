package com.fnseu.articleServer.controller;

import com.fnseu.articleServer.pojo.User;
import com.fnseu.articleServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: LiChao
 * @Date: 2019/5/30 16:37
 */
@RestController
@RefreshScope
public class UserController {

    @Autowired
    private UserService userService;

    @Value("${feign.hystrix.enabled}")
    private String testScope;

    @GetMapping(value = "/user/{id}")
    public User getUser(@PathVariable int id){
        return userService.selById(id);
    }

    @GetMapping("/user/test")
    public String testF(){
        return testScope;
    }
}
