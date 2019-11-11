package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * <br>Title: GateWatApplication
 * <br>Description: 类功能描述
 * <br>Author:dream (983214499@qq.com)
 * <br>Date:2019/11/9/10:05
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWatApplication {
    public static void main(String[] args) {
        SpringApplication.run(GateWatApplication.class, args);
    }
}
