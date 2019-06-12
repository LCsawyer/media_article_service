package com.fnseu.articleServer.mapper;

import com.fnseu.articleServer.pojo.Article;
import com.fnseu.articleServer.pojo.Article;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import sun.security.util.Password;

import java.util.List;


@Mapper

public interface UserServiceMapper {

    @Results(value = {
            @Result(id = true,property = "title",column = "title"),
            @Result(property = "Abstract",column = "abstract"),
            @Result(property="body",column ="body"),
//            @Result(property = "id",column = "id"),
//            @Result(property = "Keywords",column = "keywords"),
//            @Result(property = "entities",column = "entities"),
//            @Result(property = "source",column = "source"),
//            @Result(property = "category",column = "category")
    })
    @Select("select * from article where id=#{0}")
    Article selById(int id);

    @Delete("delete from article where id=#{0}")
    int delById(int id);
    @Select("select * from article")
    List<Article> ListArticle();
    @Results(value = {
            @Result(id = true,property = "title",column = "title"),
            @Result(property = "Abstract",column = "abstract"),
            @Result(property = "id",column = "id"),
            @Result(property = "Keywords",column = "keywords"),
            @Result(property = "entities",column = "entities"),
            @Result(property = "source",column = "source"),
            @Result(property = "category",column = "category"),
            @Result(property="body",column ="body"),
//            @Result(property = "author_id",column = "author_id")
    })

    @Insert("insert into article(id,title,abstract,keywords,entities,source,category,body)" +
            " VALUES(#{id},#{title},#{abstract},#{keywords},#{entities},#{source},#{category},#{body})")
    int saveArticle(Article article);

    @Update("update article set article.title=#{title},article.abstract=#{abstract},article.keywords=#{keywords},article.entities=#{entities},article.source=#{source},article.category=#{category},article.body=#{body} where article.id=#{id}")
    int updateArticle(Article article);
}
