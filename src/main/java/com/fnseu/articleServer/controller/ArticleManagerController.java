package com.fnseu.articleServer.controller;

import com.fnseu.articleServer.pojo.Article;
import com.fnseu.articleServer.service.ArticleManagerService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/6/12 19:37
 */
@RestController
public class ArticleManagerController {

    @Autowired
    private ArticleManagerService articleManagerService;

    //    @Value("${feign.hystrix.enabled}")
    //private String testScope;

    @ApiOperation(value = "文章上传",notes = "用户将文章上传")
    @ApiImplicitParam(name="article",value = "文章相关信息",required = true,dataType = "Article")
    @PostMapping(value="/articles")
    public String saveArticle(@RequestBody Article article){
        int index = articleManagerService.saveArticle(article);
        if (index>0){
            return "success";
        }
        return "error";
    }

    @ApiOperation(value = "文章详情查询",notes = "根据id查询文章详情")
    @ApiImplicitParam(name="id",value = "文章id",required = true,dataType = "Long",paramType = "path")
    @GetMapping(value = "/articles/{id}")
    public Article getUser(@PathVariable Long id){
        return articleManagerService.selById(id);
    }

//    @GetMapping("/articles")
//    public List<Article> ListArticle(){
//        return articleManagerService.ListArticle();
//    }

    @ApiOperation(value = "文章删除",notes = "用户根据id删除文章")
    @ApiImplicitParam(name="id",value = "文章id",required = true,dataType = "Long",paramType = "path")
    @DeleteMapping("/articles/{id}")
    public String deleteUser(@PathVariable Long id){
        int index = articleManagerService.delById(id);
        if (index>0){
            return "success";
        }
        return "error";
    }

    @ApiOperation(value = "文章更新",notes = "用户更新相关文章信息")
    @ApiImplicitParam(name="article",value = "文章相关信息，可不全",required = true,dataType = "Article")
    @PutMapping(value="/articles")
    public String updateArticle(@RequestBody Article article){
        int index = articleManagerService.updateArticle(article);
        if (index>0){
            return "success";
        }
        return "error";
    }
}
