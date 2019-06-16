package com.fnseu.articleServer.controller;

import com.fnseu.articleServer.pojo.Authentication;
import com.fnseu.articleServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

//根据审核人员编号和判定状态查询
    @GetMapping(value = "/{reviewer_id}/{STATUS}")
    public Map selAll(@PathVariable BigInteger reviewer_id, @PathVariable Integer STATUS){
        int result = userService.selAll(reviewer_id,STATUS);
        Map m1 = new HashMap();
        m1.put("TotalRecorder",result);
        return m1;
    }

    @GetMapping("/review/identity/collection/{reviewer_id}/{STATUS}/{capacity}/{current_page}")
    public Map selAuthticationList(@PathVariable BigInteger reviewer_id, @PathVariable Integer STATUS,
                                                    @PathVariable Integer capacity, @PathVariable Integer current_page){
        List<Authentication> authentications = userService.selAuthticationList(reviewer_id,STATUS,capacity,(current_page-1)*capacity);//offset值
        int TotalRecorder = userService.selAll(reviewer_id,STATUS);
        Map map = new HashMap();
        String result = null;
        if (TotalRecorder >0){
            result = "sucess";
        }else {
            result = "error";
        }
        map.put("result",result);
        map.put("TotalRecorder",TotalRecorder);
        map.put("msg",authentications);
        return map;
    }

    @GetMapping("/review/identity/{id}")
    public Map selectAuthFileById(@PathVariable int id){
        Authentication authentication = userService.selectAuthFileById(id);
        int rows = userService.RecorderNumsById(id);
        String result = rows > 0? "sucess": "error";
        Map map = new HashMap();
        map.put("result",result);
        map.put("msg",authentication);
        return map;
    }

    @PostMapping(path = "/review/identity")
    @ResponseBody
    public Map insertAuth(@RequestBody Authentication authentication){
        int rows = userService.insertAuth(authentication);

        String result = rows>0? "sucess" : "error";
        Map map = new HashMap();
        map.put("result",result);
        return map;
    }
}
