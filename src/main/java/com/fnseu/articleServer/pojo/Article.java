
package com.fnseu.articleServer.pojo;


import javax.xml.soap.Text;

public class Article {
    private String id;

    private Integer version;

    private String title;

    private String Abstract;

    private String Keywords;

    private String entities;

    private String source;

    private String category;
    private String body;
private String author_id;

public  String getAuthor_id(){
    return author_id;
    }


    public void setAuthor_id(String author_id){
    this.author_id=author_id;
    }
    public String getBody(){
        return body;
    }

    public void setBody(String body){
      this.body=body;
    }

    public Integer getVersion(){
        return version;
    }

    public void setVersion(Integer version){
        this.version=version;
    }
    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category=category;
    }
    public String getSource(){
        return source;
    }

    public void setSource(String source){
        this.source=source;
    }
    public String getEntities(){
        return entities;
    }

    public void setEntities(String entities){
        this.entities=entities;
    }
    public String getKeywords(){
        return Keywords;
    }

    public void setKeywords(String keywords){
        this.Keywords=keywords;
    }
    public String getId(){
        return id;
    }

    public void setId(String aid){
        this.id=aid;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public String getAbstract(){
        return Abstract;
    }

    public void setAbstract(String anAbstract){
        this.Abstract=anAbstract;
    }


}

