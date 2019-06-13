package com.fnseu.articleServer.mapper;

import com.fnseu.articleServer.pojo.ArticleInfo;
import com.fnseu.articleServer.pojo.ArticleReviewInfo;
import com.fnseu.articleServer.pojo.Review;
import com.fnseu.articleServer.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/6/12 19:22
 */
@Mapper
public interface ArticleReviewMapper {
    @Results(value = {
            @Result(id= true, property = "reviewId",column ="id" ),
            @Result(property = "reviewerId",column ="reviewer_id" ),
            @Result(property = "contentId",column ="content_id" ),
            @Result(property = "result",column ="result" ),
    })
    @Select("select * from review")
    List<Review> listReview();


    //查询列举审核表中内容审核项，并根据review.content_id：article.id一对一查询文章表
    @Select("SELECT * FROM review WHERE content_type=#{content_type}")
    @Results(value = {
            @Result(id= true, property = "reviewId",column ="id" ),
            @Result(property = "reviewerId",column ="reviewer_id" ),
            @Result(property = "articleInfo", column = "content_id",
                    one=@One(select = "com.fnseu.articleServer.mapper.ArticleReviewMapper.selectArticleById",fetchType= FetchType.EAGER))
    })
    List<ArticleReviewInfo> listArticleReview(Integer content_type);

    //根据id查询文章
    @Results({
            @Result(property = "status", column = "status"),
            @Result(property = "articleId", column = "id", id=true),
            @Result(property = "authorId", column = "author_id"),
            @Result(property = "title", column = "title")
    })
    @Select("SELECT * FROM article  WHERE id = #{content_id};")
    ArticleInfo selectArticleById(Long content_id);

    //根据审核结果查询审核表中的内容审核条目
    @Results(value = {
            @Result(id= true, property = "reviewId",column ="id" ),
            @Result(property = "reviewerId",column ="reviewer_id" ),
            @Result(property = "articleInfo", column = "content_id", one=@One(select =
                    "com.fnseu.articleServer.mapper.UserServiceMapper.selectArticleById",fetchType= FetchType.EAGER
            ))
    })
    @Select("SELECT * FROM review WHERE content_type=#{contType} and result=#{result}" )
    List<ArticleReviewInfo> selReviewByResult(@Param("contType") Integer content_type, @Param("result")Integer status);


    @Results(value = {
            @Result(id = true,property = "userId",column = "user_id"),
            @Result(property = "userName",column = "user_name")
    })
    @Select("select * from user where user_id=#{id}")
    User selById(Long id);

    @Results(value = {
            @Result(id = true,property = "reviewId",column = "id"),
            @Result(property = "reviewerId",column = "reviewer_id"),
            @Result(property = "contentId",column = "content_id"),
            @Result(property = "contentType",column = "content_type"),
            @Result(property = "level", column = "level"),
            @Result(property = "result", column = "result"),
            @Result(property = "reviewTime", column = "review_time"),
            @Result(property = "description", column = "description")
    })
    @Select("SELECT * FROM review where id=#{id}")
    Review selReviewById(Long id);

    @Insert({"insert into review(" +
            "id," +
            "reviewer_id," +
            "content_id," +
            "content_type," +
            "level," +
            "result," +
            "description," +
            "review_time) " +
            "values(" +
            "#{reviewId}," +
            "#{reviewer_id}," +
            "#{contentId}," +
            "#{content_type}," +
            "#{level}," +
            "#{result}," +
            "#{description}," +
            "null" +
            ")"})
    int addReview(Review rev);
}
