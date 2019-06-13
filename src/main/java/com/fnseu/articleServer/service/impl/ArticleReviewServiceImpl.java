package com.fnseu.articleServer.service.impl;

import com.fnseu.articleServer.mapper.ArticleReviewMapper;
import com.fnseu.articleServer.pojo.ArticleReviewInfo;
import com.fnseu.articleServer.pojo.Review;
import com.fnseu.articleServer.pojo.User;
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
    public static int article_type =1;
    @Resource
    private ArticleReviewMapper articleReviewMapper;


    public List<Review> listReview() {
        return articleReviewMapper.listReview();
    }

    @Override
    public User selById(Long id) {
        return articleReviewMapper.selById(id);
    }

    @Override
    public List<User> selByName(String name) {
        return null;
    }

    //内容审核列表查询
    public List<ArticleReviewInfo> listArticleReview(Integer status){
        System.out.println("status:" + status);
        if(status == -1) {
            return articleReviewMapper.listArticleReview(1);
        }
        else if(status >= 0) {
            return articleReviewMapper.selReviewByResult(1, status);
        }
        else{
            System.out.println("内容审核列表查询： 无效的status状态码");
            return  null;
        }
    }

    //内容审核详情查询
    public Review selReviewById(Long id){
        return articleReviewMapper.selReviewById(id);
    }

    //内容审核反馈
    public int addReview(Review revData){
        return articleReviewMapper.addReview(revData);
    }
}
