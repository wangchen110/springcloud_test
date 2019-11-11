package com.springcloud.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <br>Title: webConf
 * <br>Description: 类功能描述
 * <br>Author:dream (983214499@qq.com)
 * <br>Date:2019/11/7/21:14
 */
@Configuration
@Component
public class webConf implements WebMvcConfigurer {

    @Autowired
    private HandelerIntersepeter handelerIntersepeter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(handelerIntersepeter);
    }
}
