package com.cherry.schedule.core;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Cherry
 * @Date: 2020/12/22
 * @Desc: ScheduleTaskB
 */
@Component
public class ScheduleTaskB {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    /**
     * @return void
     * @Author Smith
     * @Description 设置没6秒执行一次
     * @Date 14:22 2019/1/24
     * @Param
     **/
    @Scheduled(fixedRate = 4000)
    private void process() {
        System.out.println("Task B : now time is " + dateFormat.format(new Date()));
    }
}
