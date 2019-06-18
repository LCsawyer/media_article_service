package com.fnseu.articleServer.service.impl;

import com.fnseu.articleServer.mapper.ArticleReviewMapper;
import com.fnseu.articleServer.pojo.*;
import com.fnseu.articleServer.service.ArticleReviewService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/6/12 20:24
 */
@Service("articleReviewService")
@Transactional
public class ArticleReviewServiceImpl implements ArticleReviewService{

    @Resource
    private ArticleReviewMapper articleReviewMapper;

    @Override
    public PageInfo selArticleReviews(Integer status, Integer pageNum, Integer pageSize) {
        PageInfo pageInfo = new PageInfo();
        int count = articleReviewMapper.selCountAll(status);
        if (count==0){
            return null;
        }
        int pageStart = (pageNum-1)*pageSize;
        List<ArticleReview> list = articleReviewMapper.selArticleReviews(status,pageStart,pageSize);
        if (list==null || list.size()==0) return null;
        pageInfo.setPageStart(pageStart);
        pageInfo.setPageSize(pageSize);
        pageInfo.setPageNum(pageNum);
        pageInfo.setList(list);
        pageInfo.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
        return pageInfo;
    }

    @Override
    public int insReview(Review review) {
        return articleReviewMapper.insReview(review);
    }

    @Override
    public int updStatus(Integer status, Long articleId) {
        return articleReviewMapper.updStatus(status, articleId);
    }


}
