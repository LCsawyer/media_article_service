package com.fnseu.articleServer.mapper;

import com.fnseu.articleServer.pojo.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/6/12 19:30
 */
@Mapper
public interface ArticleManagerMapper {
    @Results(value = {
            @Result(id = true,property = "title",column = "title"),
            @Result(property = "Abstract",column = "abstract"),
            @Result(property="body",column ="body")
    })
    @Select("select * from article where id=#{0}")
    Article selById(Long id);

    @Delete("delete from article where id=#{0}")
    int delById(Long id);
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
            @Result(property="body",column ="body")
    })


    @Insert("insert into article(id,title,abstract,keywords,entities,source,category,body)" +
            " VALUES(#{id},#{title},#{abstract},#{keywords},#{entities},#{source},#{category},#{body})")
    int saveArticle(Article article);

    @UpdateProvider(type = ArticleDynamicSqlProvider.class,method = "update")
    int updateArticle(Article article);
}
