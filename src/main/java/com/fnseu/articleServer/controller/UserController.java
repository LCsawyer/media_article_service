package com.fnseu.articleServer.controller;

import com.fnseu.articleServer.pojo.Authentication;
import com.fnseu.articleServer.pojo.User;
import com.fnseu.articleServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

//import org.springframework.cloud.context.config.annotation.RefreshScope;
//这是最新的
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
    private String testScope;

//根据编号查询
    @GetMapping(value = "/user/{id}")
    public User selById(@PathVariable int id){
        return userService.selById(id);
    }

    @GetMapping("/user/test")
    public String testF(){
        return testScope;
    }

    @GetMapping("/review/identity/collection/{reviewer_id}/{STATUS}/{capacity}/{current_page}")
    public List<Authentication> selAuthticationList(@PathVariable BigInteger reviewer_id, @PathVariable Integer STATUS,
                                                    @PathVariable Integer capacity, @PathVariable Integer current_page){
        return userService.selAuthticationList(reviewer_id,STATUS,capacity,(current_page-1)*capacity);//offset值
    }

    @GetMapping("/review/identity/{id}")
    public Authentication selectAuthFileById(@PathVariable int id){
        return userService.selectAuthFileById(id);
    }

    @PostMapping(path = "/review/identity.json")
    @ResponseBody
    public int insertAuth(@RequestBody Authentication authentication){
        return userService.insertAuth(authentication);
    }
}
