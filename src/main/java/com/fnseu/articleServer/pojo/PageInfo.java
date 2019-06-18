package com.fnseu.articleServer.pojo;

import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/6/17 22:04
 */
public class PageInfo {
    private Integer pageSize;
    private Integer pageNum;
    private Integer pageStart;
    private Integer total;//总页数
    private List<?> list;

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }
}
