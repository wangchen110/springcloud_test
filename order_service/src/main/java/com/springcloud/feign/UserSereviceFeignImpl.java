package com.springcloud.feign;

import org.springframework.stereotype.Component;

/**
 * <br>Title: UserSereviceFeignImpl
 * <br>Description: 类功能描述
 * <br>Author:dream (983214499@qq.com)
 * <br>Date:2019/11/5/20:32
 */
@Component
public class UserSereviceFeignImpl implements UserSereviceFeign {

    @Override
    public String getUser(Integer userId) {
        return "服务调用失败";
    }

    @Override
    public String detail() {
        return null;
    }
}
