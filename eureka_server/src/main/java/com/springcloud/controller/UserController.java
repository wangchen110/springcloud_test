package com.springcloud.controller;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <br>Title: UserController
 * <br>Description: 类功能描述
 * <br>Author:dream (983214499@qq.com)
 * <br>Date:2019/11/3/14:11
 */
@RestController
public class UserController {

    @RequestMapping("/getUser")
    public String getUser(@RequestParam("id") Integer userId) throws InterruptedException {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "张三 8081");
        map.put(2, "李四 8081");
        map.put(3, "王五 8081");
        return map.get(userId);
    }

    @GetMapping("/detail")
    public String detail() {
        return "111";
    }
}
