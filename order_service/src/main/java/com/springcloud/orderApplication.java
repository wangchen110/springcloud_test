package com.springcloud;

import com.netflix.loadbalancer.*;
import com.sun.deploy.security.ruleset.Rule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * <br>Title: orderApplication
 * <br>Description: 类功能描述
 * <br>Author:dream (983214499@qq.com)
 * <br>Date:2019/11/3/14:30
 */
@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@RibbonClient(name = "aaaaa")
@EnableHystrix
public class orderApplication {
    public static void main(String[] args) {
        SpringApplication.run(orderApplication.class, args);
    }

//    @Bean
//    @LoadBalanced
//    public RestTemplate restTemplate(){
//        return new RestTemplate();
//    }

    @Bean
    public IRule myRule()
    {
        //new RetryRule();
        //new WeightedResponseTimeRule();
        return  new RoundRobinRule();
    }

}
