package com.cherry.cloud.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Cherry
 * @Date: 2020/12/6
 * @Desc: HelloController
 */
@Api("HelloController")
@RestController
public class HelloController {

//    @ApiOperation("test hello")
//    @GetMapping("/hello")
//    public String hello() {
//        return "Hello";
//    }

    @RequestMapping("/test")
    public String hello() {
        return "hello";
    }

    @Autowired
    @RequestMapping(value = "/{text:[a-z-]+}.{number:[\\d]+}")
    public String hello1(@PathVariable String text, @PathVariable String number) {
        return "hello";
    }

}
