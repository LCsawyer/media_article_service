package com.fnseu.articleServer.mapper;

import com.fnseu.articleServer.pojo.ArticleInfo;
import com.fnseu.articleServer.pojo.ArticleReviewInfo;
import com.fnseu.articleServer.pojo.Review;
import com.fnseu.articleServer.pojo.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.math.BigInteger;
import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/5/30 16:32
 */
@Mapper
public interface UserServiceMapper {

    @Results(value = {
            @Result(id= true, property = "reviewId",column ="id" ),
            @Result(property = "reviewerId",column ="reviewer_id" ),
            @Result(property = "contentId",column ="content_id" ),
            @Result(property = "result",column ="result" ),
    })
    @Select("select * from review")
    List<Review> listReview();


    //查询列举审核表中内容审核项，并根据review.content_id：article.id一对一查询文章表
    @Select("SELECT * FROM review WHERE content_type=#{contType} limit #{offset},#{capcity}")
    @Results(value = {
            @Result(id= true, property = "reviewId",column ="id" ),
            @Result(property = "reviewerId",column ="reviewer_id" ),
            @Result(property = "articleInfo", column = "content_id",
                   one=@One(select = "com.fnseu.articleServer.mapper.UserServiceMapper.selectArticleById",fetchType= FetchType.EAGER))
    })
    List<ArticleReviewInfo> listArticleReview(@Param("contType")int content_type,@Param("capcity") int capcity,@Param("offset")int offset);

    //根据id查询文章
    @Results({
            @Result(property = "status", column = "status"),
            @Result(property = "articleId", column = "id", id=true),
            @Result(property = "authorId", column = "author_id"),
            @Result(property = "title", column = "title")
    })
    @Select("SELECT * FROM article  WHERE id = #{content_id} ;")
    ArticleInfo selectArticleById(int content_id);

    //根据审核结果查询审核表中的内容审核条目
    @Results(value = {
            @Result(id= true, property = "reviewId",column ="id" ),
            @Result(property = "reviewerId",column ="reviewer_id" ),
            @Result(property = "articleInfo", column = "content_id", one=@One(select =
                    "com.fnseu.articleServer.mapper.UserServiceMapper.selectArticleById",fetchType= FetchType.EAGER
            ))
    })
    @Select("SELECT * FROM review WHERE content_type=#{contType} and result=#{result} limit #{offset},#{capcity}" )
    List<ArticleReviewInfo> selReviewByResult(@Param("contType") int content_type, @Param("result")int status,
                                              @Param("capcity" ) int capcity, @Param("offset")int offset);


    @Results(value = {
            @Result(id = true,property = "userId",column = "user_id"),
            @Result(property = "userName",column = "user_name")
    })
    @Select("select * from user where user_id=#{id}")
    User selById(int id);

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
    Review selReviewById(long id);

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
            "#{reviewerId}," +
            "#{contentId}," +
            "#{contentType}," +
            "#{level}," +
            "#{result}," +
            "#{description}," +
            "null" +
            ")"})
    int addReview(Review rev);
}

//    @Select("SELECT review.*, " +
//            "article.title as title, " +
//            "article.author_id as userId," +
//            "article.id as articleId" +
//            "article.status as status"+
//            " FROM review LEFT JOIN article ON review.content_id = article.id " +
//            "WHERE review.content_type=#{0}")
//    @Results(value = {
//            @Result(id=true, property = "reviewId", column = "id"),
//            @Result(property = "articleId", column = "articleId"),
//            @Result(property = "userId", column = "userId"),
//            @Result(property = "title", column = "title"),
//            @Result(property = "status", column = "status")
//    }
//    )
//    List<ArticleInfo> listArticleReview(int contType);