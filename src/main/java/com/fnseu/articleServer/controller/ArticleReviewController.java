package com.fnseu.articleServer.controller;

import com.fnseu.articleServer.pojo.*;
import com.fnseu.articleServer.service.ArticleManagerService;
import com.fnseu.articleServer.service.ArticleReviewService;
import com.fnseu.articleServer.util.CodeData;
import com.fnseu.articleServer.util.RabbitMQSender;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/6/12 20:29
 */
@RestController
public class ArticleReviewController {
    @Autowired
    private ArticleReviewService articleReviewService;

    @Autowired
    private ArticleManagerService articleManagerService;

    @Autowired
    private RabbitMQSender rabbitMQSender;

//    @Value("${feign.hystrix.enabled}")
//    private String testScope;

    //内容审核列表查询
    @ApiOperation(value ="内容审核列表查询",notes="内容审核分页查询")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "status",value = "内容审核状态",required = true,dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize",value = "内容审核列表页一页条数，默认10",required = true,dataType = "Integer"),
            @ApiImplicitParam(name = "pageNum",value = "当前页号",required = true,dataType = "Integer"),
    })
    @GetMapping(value = "/articleReviews")
    public ResponseBean<PageInfo> listArticleReview(@RequestParam(defaultValue = "-1") Integer status,
                                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                                    @RequestParam(defaultValue = "1")Integer pageNum){
        PageInfo pageInfo = articleReviewService.selArticleReviews(status,pageNum,pageSize);
        if (pageInfo==null){
            return new ResponseBean<PageInfo>(CodeData.NODATA,true,"无数据",null);
        }
        return new ResponseBean<PageInfo>(CodeData.SUCCESS,true,"查询成功",pageInfo);
    }


    @ApiOperation(value = "内容审核反馈",notes = "内容审核反馈,反馈信息存入消息队列")
    @ApiImplicitParam(name="articleReview",value = "内容反馈信息",required = true,dataType = "Review")
    @PostMapping(value = "/articleReviews")
    public ResponseBean addArticleReview(@RequestBody Review articleReview){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        articleReview.setReviewTime(timestamp);
        Long id = articleManagerService.selAuthorId(articleReview.getContentId());
        articleReview.setAuthorId(id);
        articleReviewService.insReview(articleReview);
        int index = articleReviewService.updStatus(articleReview.getResult(),articleReview.getContentId());
        if(index<=0){
            return new ResponseBean(CodeData.FEAILED,false,"插入失败",null);
        }
        rabbitMQSender.senderArticleReviewInfo(articleReview);
        return new ResponseBean(CodeData.SUCCESS,true,"成功",null);
    }
}
