package com.cherry.mq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @Author : 翁鑫豪
 * @Date : 2022/1/22 21:31
 * @Description: MessageMQProducerDemo
 */
@EnableOpenApi
@SpringBootApplication
@ComponentScan(basePackages = "com.cherry.*")
public class MessageMQProducerDemo {

    public static void main(String[] args) {
        SpringApplication.run(MessageMQProducerDemo.class, args);
    }
}
