package com.fnseu.articleServer.controller;

import com.fnseu.articleServer.pojo.Authentication;
import com.fnseu.articleServer.pojo.User;
import com.fnseu.articleServer.service.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/5/30 16:37
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //根据编号查询
//    @GetMapping(value = "/user/{id}")
//    public User selById(@PathVariable Long id){
//        return userService.selById(id);
//    }


    @ApiOperation(value = "身份审核申请列表查询",notes="查询用户身份认证信息，分页查询方式")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name="reviewer_id",value="审核人员id",required = true,dataType = "Long"),
            @ApiImplicitParam(name="STATUS",value="审核状态",required = true,dataType = "Integer"),
            @ApiImplicitParam(name="size",value="一页显示条数，默认10",required = true,dataType = "Integer"),
            @ApiImplicitParam(name="current_page",value="当前页号",required = true,dataType = "Integer")
    })
    @GetMapping("/userReviews")
    public List<Authentication> selAuthticationList(@RequestParam Long reviewer_id, @RequestParam Integer STATUS,
                                                    @RequestParam(defaultValue = "10") Integer size, @RequestParam Integer current_page){
        return userService.selAuthticationList(reviewer_id,STATUS,size,(current_page-1)*size);//offset值
    }


    @ApiOperation(value="认证文件查询",notes="查询用户上传的认证文件")
    @ApiImplicitParam(name="id",value="认证文件id",required = true,dataType = "Long",paramType = "path")
    @GetMapping("/userReviews/identity/{id}")
    public Authentication selectAuthFileById(@PathVariable Long id){
        return userService.selectAuthFileById(id);
    }

    @ApiOperation(value = "身份审核反馈",notes="向用户反馈审核结果")
    @ApiImplicitParam(name="authentication",value="审核反馈信息",required = true,dataType = "Authentication")
    @PostMapping(path = "/UserReviews")
    public String insertAuth(@RequestBody Authentication authentication){
        int index = userService.insertAuth(authentication);
        if (index>0){
            return "success";
        }
        return "error";
    }
}
