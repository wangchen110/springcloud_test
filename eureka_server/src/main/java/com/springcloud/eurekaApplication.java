package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <br>Title: eurekaApplication
 * <br>Description: 类功能描述
 * <br>Author:dream (983214499@qq.com)
 * <br>Date:2019/11/1/21:19
 */
@EnableFeignClients
@SpringBootApplication
@EnableEurekaClient
public class eurekaApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(eurekaApplication.class,args);
    }

}
