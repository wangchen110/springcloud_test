package com.springcloud.controller;

import com.springcloud.conf.OvertimeConnect;
import com.springcloud.feign.UserSereviceFeign;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * <br>Title: OrderController
 * <br>Description: 类功能描述
 * <br>Author:dream (983214499@qq.com)
 * <br>Date:2019/11/3/14:31
 */
@RestController
@RequestMapping("/order")
public class OrderController {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserSereviceFeign userSereviceFeign;

    private Integer sum = 0;

    @OvertimeConnect(time = 10, count = 3)
    @RequestMapping("/{id}")
    public String getUser(@PathVariable("id") Integer userId, HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        System.out.println(requestURI);
        String userName = "";
        userName = userSereviceFeign.getUser(userId);

        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);
        ValueOperations ops = redisTemplate.opsForValue();

        if (redisTemplate.hasKey("out")) {
            if (sum == 6) {
                return "一分钟内访问次数达到上限";
            } else {

            }
        } else {
            System.out.println("用户第一次访问");
            sum = 1;
            ops.set("out", sum, 1, TimeUnit.MINUTES);
        }

        return "这是" + userName + "的座位";

        //restTemplate 发送请求 底层是对httpclient做的封装  使用时需手动注入restTemplatee
//        Map<String,String> map = new HashMap<>();
//        map.put("id",String.valueOf(userId));
//        userName = restTemplate.getForObject("http://aaaaa/getUser?id={id}", String.class,map);

        //httpclient 发送请求
        //https://blog.csdn.net/justry_deng/article/details/81042379
        /*
        CloseableHttpClient httpClient=null;
        CloseableHttpResponse httpResponse=null;
        try {
            //httpClient = HttpClientBuilder.create().build();
            //1：创建httpclient
            httpClient = HttpClients.createDefault();
            //2：创建uri
            URIBuilder uriBuilder = new URIBuilder("http://localhost:6066/user/getUser");
            //设置参数
            uriBuilder.addParameter("id",String.valueOf(userId));
            URI uri = uriBuilder.build();

            //需传中文参数时
            URLEncoder.encode("张三","utf-8");

            //3：创建相对应的请求方式
            HttpGet httpGet = new HttpGet(uri);
            // 设置请求配置信息
            RequestConfig requestConfig = RequestConfig.custom()
                    // 设置连接超时时间(单位毫秒)
                    .setConnectTimeout(5000)
                    // 设置请求超时时间(单位毫秒)
                    .setConnectionRequestTimeout(5000)
                    // socket读写超时时间(单位毫秒)
                    .setSocketTimeout(5000)
                    // 设置是否允许重定向(默认为true)
                    .setRedirectsEnabled(true).build();
            httpGet.setConfig(requestConfig);

            //4：执行请求 接受请求后的结果
            httpResponse =  httpClient.execute(httpGet);
            //5：解析请求结果
            if(httpResponse.getStatusLine().getStatusCode()==200 &&  httpResponse!=null)
            {
                userName = EntityUtils.toString( httpResponse.getEntity(),"UTF-8");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
               httpClient.close();
               httpResponse.close();
           }catch (IOException e )
           {
               e.printStackTrace();
           }
        }*/
    }
}
