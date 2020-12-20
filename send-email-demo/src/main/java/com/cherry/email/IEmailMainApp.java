package com.cherry.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @Author: Cherry
 * @Date: 2020/12/20
 * @Desc: IEmailMainApp
 */
@EnableOpenApi
@SpringBootApplication
public class IEmailMainApp {

    public static void main(String[] args) {
        SpringApplication.run(IEmailMainApp.class, args);
    }
}
