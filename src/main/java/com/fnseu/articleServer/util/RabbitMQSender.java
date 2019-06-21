package com.fnseu.articleServer.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fnseu.articleServer.pojo.AuthReviewInfo;
import com.fnseu.articleServer.pojo.Review;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: LiChao
 * @Date: 2019/6/21 15:42
 */
@Component
public class RabbitMQSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void senderUserReviewInfo(AuthReviewInfo authReviewInfo)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        String msg = "";
        try{
            msg = objectMapper.writeValueAsString(authReviewInfo);
        }catch (Exception e){}

        amqpTemplate.convertAndSend("inform-exchange","userReview-queue",msg);
    }

    public void senderArticleReviewInfo(Review articleReview){
        String msg = "";
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            msg = objectMapper.writeValueAsString(articleReview);
        }
        catch (Exception e){}
        amqpTemplate.convertAndSend("inform-exchange","articleReview-queue",msg);
    }


}
