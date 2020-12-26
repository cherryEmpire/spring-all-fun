package com.cherry.email.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @Author: Cherry
 * @Date: 2020/12/20
 * @Desc: MyEmailConfig
 */
@Configuration
@ConfigurationProperties(prefix = "spring.email")
public class MyEmailConfig {

    //    @Value("${spring.email.host}")
    private String host;

    //    @Value("${spring.email.username}")
    private String username;

    //    @Value("${spring.email.password}")
    private String password;

    @Bean
    public JavaMailSenderImpl mailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
//        javaMailSender.setProtocol("SMTP");
        javaMailSender.setHost(host);
        javaMailSender.setUsername(username);
        javaMailSender.setPassword(password);
        return javaMailSender;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
