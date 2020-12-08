package com.cherry.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @Author: Cherry
 * @Date: 2020/12/7
 * @Desc: IElasticsearchDemo
 */
@EnableOpenApi
@SpringBootApplication
public class IElasticsearchDemo {
    public static void main(String[] args) {
        SpringApplication.run(IElasticsearchDemo.class, args);
    }
}
