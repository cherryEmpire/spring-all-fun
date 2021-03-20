package com.cherry.fastdfs;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * @Author: Cherry
 * @Date: 2021/3/20
 * @Desc: FastDFSDemo
 */
@Configuration
@EnableOpenApi
@SpringBootApplication
@Import(FdfsClientConfig.class)
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class FastDFSDemo {

    public static void main(String[] args) {
        SpringApplication.run(FastDFSDemo.class, args);
    }
}
