package com.cherry.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @Author: Cherry
 * @Date: 2020/12/8
 * @Desc: Swagger3CommonConfig
 */
@Configuration
public class Swagger3CommonConfig {

    /**
     * api接口包扫描路径
     */
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.cherry";

    public static final String VERSION = "1.0.1.RC";

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //设置文档的标题
                .title("一叶飘零Cherry")
                // 设置文档的描述
                .description("逝者如斯夫，不舍昼夜！")
                .contact(new Contact("Cherry", "#", "180835910@qq.com"))
                .version(VERSION)
                .build();
    }
}
