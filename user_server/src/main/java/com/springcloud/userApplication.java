package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <br>Title: userApplication
 * <br>Description: 类功能描述
 * <br>Author:dream (983214499@qq.com)
 * <br>Date:2019/11/1/21:10
 */
@EnableEurekaServer
@SpringBootApplication
public class userApplication {

    public static void main(String[] args) {
        SpringApplication.run(userApplication.class,args);
    }
}
