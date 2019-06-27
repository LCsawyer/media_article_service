package com.fnseu.articleServer.controller;

import com.fnseu.articleServer.pojo.Article;
import com.fnseu.articleServer.pojo.PageInfo;
import com.fnseu.articleServer.pojo.ResponseBean;
import com.fnseu.articleServer.service.ArticleManagerService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

    @ApiOperation(value = "文章保存",notes = "用户将文章保存")
    @ApiImplicitParam(name="article",value = "title、body、pictures和level用户自己填写，" +
            "id和version无论有无均需上传,时间相关属性不上传",required = true,dataType = "Article")
    @PostMapping(value="/articles")
    public ResponseBean saveArticle(@RequestBody Article article,HttpServletRequest request){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String userIdStr = request.getHeader("userId");
        if (userIdStr==null){
            return new ResponseBean(404,"No user",null);
        }
        Long userId = Long.parseLong(userIdStr);
        article.setAuthorId(userId);
        article.setStatus(0);
        int index =0;
        if (article.getId()==null || article.getId()==0){
            article.setCreateTime(timestamp);
            index = articleManagerService.saveArticle(article);
        }
        else{
            int status = articleManagerService.selStatus(article.getId(),article.getVersion());
            if (status==0){
                article.setUpdateTime(timestamp);
                index = articleManagerService.updateArticle(article);
            }
            else{
                article.setCreateTime(timestamp);
                article.setVersion(article.getVersion()+1);
                index = articleManagerService.insArticle(article);
            }
        }
        if (index<=0){
            return new ResponseBean(404,"Not Found",null);
        }
        else{
            return new ResponseBean(201,"created",null);
        }
    }

    @ApiOperation(value = "文章提交",notes = "用户将文章提交")
    @ApiImplicitParam(name="article",value = "title、body、pictures和level用户自己填写，" +
                    "id和version无论有无均需上传，时间相关属性不上传",required = true,dataType = "Article")
    @PostMapping(value = "/articles/submit")
    public ResponseBean submitArticle(@RequestBody Article article,HttpServletRequest request){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String userIdStr = request.getHeader("userId");
        if (userIdStr==null){
            return new ResponseBean(404,"No user",null);
        }
        Long userId = Long.parseLong(userIdStr);
        article.setAuthorId(userId);
        article.setCommitTime(timestamp);
        int index = 0;
        article.setStatus(article.getLevel()+1);
        if (article.getId()==null || article.getId()==0){
            article.setCreateTime(timestamp);
            index = articleManagerService.saveArticle(article);
        }
        else{
            int status = articleManagerService.selStatus(article.getId(),article.getVersion());
            if (status==0){
                index = articleManagerService.updStatus(article.getId(),article.getStatus(),article.getVersion());
            }
            else{
                article.setVersion(article.getVersion()+1);
                index = articleManagerService.insArticle(article);
            }
        }
        if (index<=0){
            return new ResponseBean(404,"Not Found",null);
        }
        else{
            return new ResponseBean(201,"created",null);
        }
    }


    @ApiOperation(value = "文章详情查询",notes = "根据id查询文章详情")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name="id",value = "文章id",required = true,dataType = "Long",paramType = "path"),
            @ApiImplicitParam(name="version",value = "文章版本",required = true,dataType = "Integer",paramType = "path")
    })
    @GetMapping(value = "/articles/{id}/{version}")
    public ResponseBean<Article> getArticle(@PathVariable Long id,@PathVariable Integer version){
        Article article = articleManagerService.selById(id,version);
        if (article==null){
            return new ResponseBean<Article>(404,"Not Found",null);
        }
        return new ResponseBean<Article>(200,"ok",article);
    }

    @ApiOperation(value = "文章列表分页查询",notes="根据作者id,作者id不用显示传，和文章状态查询")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name="status",value="文章状态",required = true,dataType = "Integer"),
            @ApiImplicitParam(name="pageNum",value="当前页号从1开始，默认1",required = true,dataType = "Integer"),
            @ApiImplicitParam(name="pageSize",value="一页显示条数，默认10",required = true,dataType = "Integer"),
    })
    @GetMapping("/articles")
    public ResponseBean<PageInfo> ListArticle(@RequestParam Integer status,
                                              @RequestParam(defaultValue = "1") Integer pageNum,
                                              @RequestParam(defaultValue = "10") Integer pageSize,HttpServletRequest request){
        String userIdStr = request.getHeader("userId");
        if (userIdStr==null){
            return new ResponseBean<>(404,"No user",null);
        }
        Long userId = Long.parseLong(userIdStr);
        //System.out.println(userId);
        PageInfo pageInfo = articleManagerService.selArticleList(userId,status,pageNum,pageSize);
        if (pageInfo==null){
            return new ResponseBean<PageInfo>(404,"Not Found",null);
        }
        return new ResponseBean<PageInfo>(200,"ok",pageInfo);
    }

    @ApiOperation(value = "文章删除",notes = "用户根据id删除文章")
    @ApiImplicitParams(
            value = {
                    @ApiImplicitParam(name="id",value = "文章id",required = true,dataType = "Long",paramType = "path"),
                    @ApiImplicitParam(name="version",value = "文章版本",required = true,dataType = "Integer",paramType = "path"),
            }
    )
    @DeleteMapping("/articles/{id}/{version}")
    public ResponseBean deleteUser(@PathVariable Long id,@PathVariable Integer version){
        int index = articleManagerService.delById(id,version);
        if (index>0){
            return new ResponseBean(201,"delete",null);
        }
        return new ResponseBean(404,"Not Found",null);
    }

}
