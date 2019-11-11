package com.springcloud.conf;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * <br>Title: HandelerIntersepeter
 * <br>Description: 类功能描述
 * <br>Author:dream (983214499@qq.com)
 * <br>Date:2019/11/7/19:56
 */
@Component
public class HandelerIntersepeter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("进入拦截器");
        if (handler instanceof HandlerMethod) {
            HandlerMethod hm = (HandlerMethod) handler;
            Method method = hm.getMethod();
            if (method.isAnnotationPresent(OvertimeConnect.class)) {
                OvertimeConnect annotation = method.getAnnotation(OvertimeConnect.class);
                System.out.println(annotation);
            }
        }
        return true;
    }
}
