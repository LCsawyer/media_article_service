package com.fnseu.articleServer.controller;

import com.fnseu.articleServer.pojo.ArticleReviewInfo;
import com.fnseu.articleServer.pojo.Review;
import com.fnseu.articleServer.pojo.User;
import com.fnseu.articleServer.service.ArticleReviewService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/6/12 20:29
 */
@RestController
public class ArticleReviewController {
    @Autowired
    private ArticleReviewService articleReviewService;

//    @Value("${feign.hystrix.enabled}")
//    private String testScope;

    //内容审核列表查询
    @ApiOperation(value ="内容审核列表查询",notes="内容审核分页查询")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "status",value = "内容审核状态",required = true,dataType = "Integer"),
            @ApiImplicitParam(name = "size",value = "内容审核列表页一页条数，默认10",required = true,dataType = "Integer"),
            @ApiImplicitParam(name = "currentPage",value = "当前页号",required = true,dataType = "Integer"),
    })
    @GetMapping(value = "/articleReviews")
    public List<ArticleReviewInfo> listArticleReview(@RequestParam(defaultValue = "-1") Integer status,
                                                     @RequestParam(defaultValue = "10") Integer size,
                                                     @RequestParam(defaultValue = "1")Integer currentPage){
        return articleReviewService.listArticleReview(status);
    }

    //内容审核详情查询
    @ApiOperation(value = "内容审核详情查询",notes = "内容审核详情查询")
    @ApiImplicitParam(name="id",value = "内容id",required = true,dataType = "Long",paramType = "path")
    @GetMapping(value = "/articleReviews/{id}")
    public Review selReviewById(@PathVariable Long id){
        return articleReviewService.selReviewById(id);
    }
    //    @GetMapping("/user/test")
//    public String testF(){
//        return testScope;
//    }
    //内容审核反馈

    @ApiOperation(value = "内容审核反馈",notes = "内容审核反馈")
    @ApiImplicitParam(name="articleReview",value = "内容反馈信息",required = true,dataType = "Review")
    @PostMapping(value = "/articleReviews")
    public String addArticleReview(@RequestBody Review articleReview){
        int index = articleReviewService.addReview(articleReview);
        if (index>0){
            return "success";
        }
        return "error";
    }
}
