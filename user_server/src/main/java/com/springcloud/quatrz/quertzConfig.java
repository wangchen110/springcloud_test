package com.springcloud.quatrz;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <br>Title: quertzConfig
 * <br>Description: 类功能描述
 * <br>Author:dream (983214499@qq.com)
 * <br>Date:2019/11/3/22:10
 */
//@Configuration
public class quertzConfig {

    @Bean
    public JobDetail testQuartz1() {
        return JobBuilder.newJob(quatrztask.class).withIdentity("quatrztask").storeDurably().build();
    }

    @Bean
    public Trigger testQuartzTrigger1() {
        //5秒执行一次
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(5)
                .repeatForever();
        return TriggerBuilder.newTrigger().forJob(testQuartz1())
                .withIdentity("quatrztask")
                .withSchedule(scheduleBuilder)
                .build();
    }
}
