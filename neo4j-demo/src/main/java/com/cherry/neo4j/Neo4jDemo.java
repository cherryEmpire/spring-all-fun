package com.cherry.neo4j;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @Author : 翁鑫豪
 * @Date : 2021/12/13 13:44
 * @Description: com.cherry.neo4j.Neo4jDemo
 */
@EnableOpenApi
@SpringBootApplication
//@ComponentScan(basePackages = "com.cherry.*")
@EnableNeo4jRepositories
public class Neo4jDemo {

    public static void main(String[] args) {
        SpringApplication.run(Neo4jDemo.class, args);
    }
}
