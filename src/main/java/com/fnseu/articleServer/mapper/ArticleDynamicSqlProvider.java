package com.fnseu.articleServer.mapper;

import com.fnseu.articleServer.pojo.Article;
import org.apache.ibatis.jdbc.SQL;

/**
 * @Author: LiChao
 * @Date: 2019/6/12 21:58
 */
public class ArticleDynamicSqlProvider {
    public String update(Article article){
        return new SQL(){
            {
                UPDATE("article");
                if (article.getTitle()!=null || !article.getTitle().equals("")){
                    SET("title=#{title}");
                }
                if (article.getAbstract()!=null || !article.getAbstract().equals("")){
                    SET("abstract=#{abstract}");
                }
                if (article.getKeywords()!=null || !article.getKeywords().equals("")){
                    SET("keywords=#{keywords}");
                }
                if (article.getEntities()!=null || !article.getEntities().equals("")){
                    SET("entities=#{entities}");
                }
                if (article.getSource()!=null || !article.getSource().equals("")){
                    SET("source=#{source}");
                }
                if (article.getCategory()!=null || !article.getCategory().equals("")){
                    SET("category=#{category}");
                }
                if (article.getBody()!=null || !article.getBody().equals("")){
                    SET("body=#{body}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }
}
