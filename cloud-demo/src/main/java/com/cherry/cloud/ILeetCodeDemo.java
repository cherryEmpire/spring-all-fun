package com.cherry.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @Author: Cherry
 * @Date: 2020/12/6
 * @Desc: ILeetCodeDemo
 */
@EnableOpenApi
@SpringBootApplication
@ComponentScan(basePackages = "com.cherry.*")
public class ILeetCodeDemo {

    public static void main(String[] args) {
        SpringApplication.run(ILeetCodeDemo.class, args);
    }
}
