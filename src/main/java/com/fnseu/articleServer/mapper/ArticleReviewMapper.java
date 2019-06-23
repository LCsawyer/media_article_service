package com.fnseu.articleServer.mapper;

import com.fnseu.articleServer.pojo.*;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/6/12 19:22
 */
@Mapper
public interface ArticleReviewMapper {

    @Select("select count(*) from article where status=#{0}")
    int selCountAll(Integer status);

    @Results(value = {
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "description",column = "description")
    })
    @Select("select id,title,author,abstract,level,status from article where status=#{0} limit #{1},#{2}")
    List<ArticleReview> selArticleReviews(Integer status,Integer pageStart,Integer pageSize);

    @Insert("Insert into review values(default,#{reviewerId},#{contentId},#{contentType},#{level}," +
            "#{result},#{description},#{reviewTime})")
    int insReview(Review review);

    @Update("update article set status=#{0} where id=#{1}")
    int updStatus(Integer status,Long articleId);


}
