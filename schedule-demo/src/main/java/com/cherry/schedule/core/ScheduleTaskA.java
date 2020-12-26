package com.cherry.schedule.core;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: Cherry
 * @Date: 2020/12/22
 * @Desc: ScheduleTaskA
 */
@Component
public class ScheduleTaskA {

    private int count = 0;

    /**
     * @return void
     * @Author Smith
     * @Description 设置没6秒执行一次
     * @Date 14:23 2019/1/24
     * @Param
     **/
    @Scheduled(cron = "*/3 * * * * ?")
    private void process() {
        System.out.println("Task A : this is scheduler task A running " + (count++));
    }
}

