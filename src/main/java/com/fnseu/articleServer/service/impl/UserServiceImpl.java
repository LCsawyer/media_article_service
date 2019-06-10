package com.fnseu.articleServer.service.impl;

import com.fnseu.articleServer.mapper.UserServiceMapper;
import com.fnseu.articleServer.pojo.ArticleInfo;
import com.fnseu.articleServer.pojo.ArticleReviewInfo;
import com.fnseu.articleServer.pojo.Review;
import com.fnseu.articleServer.service.UserService;
import com.fnseu.articleServer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigInteger;
import java.util.List;

/**
 * @Author: LiChao
 * @Date: 2019/5/30 16:31
 */
@Service("userService")
@Transactional

public class UserServiceImpl implements UserService {

    public static int article_type =1;
    @Resource
    private UserServiceMapper userServiceMapper;


    public List<Review> listReview() {
        return userServiceMapper.listReview();
    }

    @Override
    public User selById(int id) {
        return userServiceMapper.selById(id);
    }

    @Override
    public List<User> selByName(String name) {
        return null;
    }

    //内容审核列表查询
    public List<ArticleReviewInfo> listArticleReview(int status){
        System.out.println("status:" + status);
//        try {
//            if(status == -1) {
//                System.out.println("here");
//                return userServiceMapper.listArticleReview(article_type);
//            }
//            else if(status ==1 || status ==0)
//                return userServiceMapper.selReviewByResult(article_type, status);
//        }catch (Exception e){
//            System.out.println("内容审核列表查询： 无效的status状态码");
//        }
        if(status == -1) {
            return userServiceMapper.listArticleReview(1);
        }
        else if(status >= 0) {
            return userServiceMapper.selReviewByResult(1, status);
        }
        else{
            System.out.println("内容审核列表查询： 无效的status状态码");
            return  null;
        }
    }

    //内容审核详情查询
    public Review selReviewById(long id){
        return userServiceMapper.selReviewById(id);
    }

    //内容审核反馈
    public String addReview(Review revData){

        try{
            userServiceMapper.addReview(revData);
            System.out.println("Inserting Review...Done");
            return "Inserting Review...Done!";
        }catch (Exception e){
            System.out.println("wrong insert of Review ");
            return "Wrong insert of Review! ";
        }
    }
}
