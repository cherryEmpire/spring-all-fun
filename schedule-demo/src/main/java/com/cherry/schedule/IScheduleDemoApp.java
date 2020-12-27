package com.cherry.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author: Cherry
 * @Date: 2020/12/22
 * @Desc: IScheduleDemoApp
 */
@SpringBootApplication
@EnableScheduling
public class IScheduleDemoApp {
    public static void main(String[] args) {
        SpringApplication.run(IScheduleDemoApp.class, args);
    }
}
