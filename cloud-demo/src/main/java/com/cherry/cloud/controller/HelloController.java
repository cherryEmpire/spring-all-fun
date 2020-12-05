package com.cherry.cloud.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Cherry
 * @Date: 2020/12/6
 * @Desc: HelloController
 */
@Api("HelloController")
@RestController
public class HelloController {

    @ApiOperation("test hello")
    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

}
