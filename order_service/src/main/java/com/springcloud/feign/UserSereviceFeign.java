package com.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <br>Title: UserSereviceFeign
 * <br>Description: 类功能描述
 * <br>Author:dream (983214499@qq.com)
 * <br>Date:2019/11/3/15:28
 */
@FeignClient(name = "aaaaa", fallback = UserSereviceFeignImpl.class)
public interface UserSereviceFeign {

    @RequestMapping("/getUser")
    String getUser(@RequestParam("id") Integer userId);

    @GetMapping("/detail")
    String detail();
}
