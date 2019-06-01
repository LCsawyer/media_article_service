package com.fnseu.articleServer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @Author: LiChao
 * @Date: 2019/5/30 16:23
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.fnseu.articleServer.mapper")
public class App {
    public static void main(String[] args){
        SpringApplication.run(App.class,args);
    }
}
