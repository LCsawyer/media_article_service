package com.fnseu.articleServer.controller;

import com.fnseu.articleServer.pojo.*;
import com.fnseu.articleServer.service.UserService;
import com.fnseu.articleServer.util.RabbitMQSender;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/5/30 16:37
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RabbitMQSender rabbitMQSender;

    //根据编号查询
//    @GetMapping(value = "/user/{id}")
//    public User selById(@PathVariable Long id){
//        return userService.selById(id);
//    }


    @ApiOperation(value = "身份审核申请列表查询",notes="查询用户身份认证信息，分页查询方式,")
    @ApiImplicitParams(value = {
//            @ApiImplicitParam(name="reviewer_id",value="审核人员id",required = true,dataType = "Long"),
            @ApiImplicitParam(name="STATUS",value="审核状态",required = true,dataType = "Integer"),
            @ApiImplicitParam(name="pageSize",value="一页显示条数，默认10",required = true,dataType = "Integer"),
            @ApiImplicitParam(name="pageNum",value="当前页号",required = true,dataType = "Integer")
    })
    @GetMapping("/userReviews")
    public ResponseBean<PageInfo> selAuthticationList(@RequestParam Integer STATUS, @RequestParam(defaultValue = "10")
            Integer pageSize, @RequestParam Integer pageNum, HttpServletRequest request){
        String userIdStr = request.getHeader("userId");
        if (userIdStr==null){
            return new ResponseBean<>(404,"No user",null);
        }
        Long reviewer_id = Long.parseLong(userIdStr);
        PageInfo pageInfo = userService.selAuthticationList(reviewer_id,STATUS,pageNum,pageSize);//offset值
        if (pageInfo==null){
            return new ResponseBean<PageInfo>(404,"Not Found",null);
        }
        return new ResponseBean<PageInfo>(200,"ok",pageInfo);
    }


    @ApiOperation(value="认证文件查询",notes="查询用户上传的认证文件")
    @ApiImplicitParam(name="id",value="认证文件id",required = true,dataType = "Long",paramType = "path")
    @GetMapping("/userReviews/identity/{id}")
    public ResponseBean<Authentication> selectAuthFileById(@PathVariable Long id){
        Authentication authentication = userService.selectAuthFileById(id);
        if (authentication==null){
            return new ResponseBean<Authentication>(404,"Not Found",null);
        }
        return new ResponseBean<Authentication>(200,"ok",authentication);
    }

    @ApiOperation(value = "身份审核反馈",notes="向用户反馈审核结果，反馈信息存入消息队列")
    @ApiImplicitParam(name="authentication",value="审核反馈信息",required = true,dataType = "AuthReviewInfo")
    @PostMapping(path = "/UserReviews")
    public ResponseBean insertAuth(@RequestBody AuthReviewInfo authentication){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        authentication.setReviewTime(timestamp);
        userService.updAuthReview(authentication);
        rabbitMQSender.senderUserReviewInfo(authentication);
        return new ResponseBean(200,"ok",null);
    }
}
