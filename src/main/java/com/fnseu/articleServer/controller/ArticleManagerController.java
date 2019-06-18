package com.fnseu.articleServer.controller;

import com.fnseu.articleServer.pojo.Article;
import com.fnseu.articleServer.pojo.PageInfo;
import com.fnseu.articleServer.pojo.ResponseBean;
import com.fnseu.articleServer.service.ArticleManagerService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
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
    public ResponseBean saveArticle(@RequestBody Article article){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        article.setCreateTime(timestamp);
        int index = articleManagerService.saveArticle(article);
        if (index>0){
            return new ResponseBean(201,"Created",null);
        }
        return new ResponseBean(404,"Not Found",null);
    }

    @ApiOperation(value = "文章详情查询",notes = "根据id查询文章详情")
    @ApiImplicitParam(name="id",value = "文章id",required = true,dataType = "Long",paramType = "path")
    @GetMapping(value = "/articles/{id}")
    public ResponseBean<Article> getUser(@PathVariable Long id){
        Article article = articleManagerService.selById(id);
        if (article==null){
            return new ResponseBean<Article>(404,"Not Found",null);
        }
        return new ResponseBean<Article>(200,"ok",article);
    }

    @ApiOperation(value = "文章列表分页查询",notes="根据作者id和文章状态查询")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name="authorId",value="作者ID",required = true,dataType = "Long"),
            @ApiImplicitParam(name="status",value="文章状态",required = true,dataType = "Integer"),
            @ApiImplicitParam(name="pageNum",value="当前页号从1开始，默认1",required = true,dataType = "Integer"),
            @ApiImplicitParam(name="pageSize",value="一页显示条数，默认10",required = true,dataType = "Integer"),
    })
    @GetMapping("/articles")
    public ResponseBean<PageInfo> ListArticle(@RequestParam Long authorId,@RequestParam Integer status,
                                              @RequestParam(defaultValue = "1") Integer pageNum,
                                              @RequestParam(defaultValue = "10") Integer pageSize){
        PageInfo pageInfo = articleManagerService.selArticleList(authorId,status,pageNum,pageSize);
        if (pageInfo==null){
            return new ResponseBean<PageInfo>(404,"Not Found",null);
        }
        return new ResponseBean<PageInfo>(200,"ok",pageInfo);
    }

    @ApiOperation(value = "文章删除",notes = "用户根据id删除文章")
    @ApiImplicitParam(name="id",value = "文章id",required = true,dataType = "Long",paramType = "path")
    @DeleteMapping("/articles/{id}")
    public ResponseBean deleteUser(@PathVariable Long id){
        int index = articleManagerService.delById(id);
        if (index>0){
            return new ResponseBean(201,"delete",null);
        }
        return new ResponseBean(404,"Not Found",null);
    }

    @ApiOperation(value = "文章更新",notes = "用户更新相关文章信息")
    @ApiImplicitParam(name="article",value = "文章相关信息，可不全",required = true,dataType = "Article")
    @PutMapping(value="/articles")
    public ResponseBean updateArticle(@RequestBody Article article){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        article.setUpdateTime(timestamp);
        int index = articleManagerService.updateArticle(article);
        if (index>0){
            return new ResponseBean(201,"update",null);
        }
        return new ResponseBean(404,"Not found",null);
    }
}
