package com.fnseu.articleServer.mapper;

import com.fnseu.articleServer.pojo.Article;
import com.fnseu.articleServer.pojo.ArticleInfo;
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
            @Result(property = "descriptions",column = "abstract"),
            @Result(property="isOriginal",column ="is_original"),
            @Result(property = "authorId",column = "author"),
            @Result(property = "publishTime",column = "publish_time")
    })
    @Select("select * from article where id=#{0} and version=#{1}")
    Article selById(Long id);

    @Delete("delete from article where id=#{0} and version=#{1}")
    int delById(Long id);

    @Results(value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "title",column = "title"),
            @Result(property = "status",column = "status"),
    })
    @Select("select id,title,status from article where author=#{0} and status=#{1} limit #{2},#{3}")
    List<ArticleInfo> selListArticle(Long authorId, Integer status, Integer pageStart, Integer pageSize);

    @Select("select count(*) from article where author=#{0} and status=#{1}")
    int selCount(Long authorId, Integer status);

    @Insert("insert into article(id,version,title,author,body,abstract,keywords,entities,pictures,level,source," +
            "category,subcategory,is_original,create_time,commit_time) VALUES(default,1,#{title},#{authorId},#{body}," +
            "#{descriptions},#{keywords},#{entities},#{pictures},#{level},#{source},#{category}," +
            "#{subcategory},#{isOriginal},#{createTime},#{commitTime})")
    int saveArticle(Article article);

    @Insert("insert into article(id,version,title,author,body,abstract,keywords,entities,pictures,level,source," +
            "category,subcategory,is_original,create_time) VALUES(#{id},#{version},#{title},#{authorId},#{body}," +
            "#{descriptions},#{keywords},#{entities},#{pictures},#{level},#{source},#{category}," +
            "#{subcategory},#{isOriginal},#{createTime})")
    int insArticle(Article article);

    @UpdateProvider(type = ArticleDynamicSqlProvider.class,method = "update")
    int updateArticle(Article article);

    @Select("select author from article where id=#{0}")
    Long selUserIdByCountId(Long id);

    @Update("update article set status=#{1} where id=#{0} and version=#{3}")
    int updStatus(Long id,Integer status,Integer version);
}
