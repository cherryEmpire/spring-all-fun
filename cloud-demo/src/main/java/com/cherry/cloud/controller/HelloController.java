package com.cherry.cloud.controller;

import com.cherry.common.enums.ErrorCodeEnum;
import com.cherry.common.exception.CherryBusinessException;
import com.cherry.common.vo.CommonResult;
import io.swagger.annotations.Api;
import lombok.SneakyThrows;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping(value = "/{text:[a-z-]+}.{number:[\\d]+}")
    public String hello1(@PathVariable String text, @PathVariable String number) {
        return "hello";
    }

    @SneakyThrows
    @RequestMapping("/test/exception/{code}")
    @ResponseBody
    public CommonResult exception(@PathVariable(value = "code") int code) {
        switch (code) {
            case 200:
                return CommonResult.succeed(ErrorCodeEnum.SUCCESS);
            case 401:
                throw new CherryBusinessException(ErrorCodeEnum.NO_AUTH);
            case 403:
                throw new CherryBusinessException(ErrorCodeEnum.NO_PERMISSION);
            case 404:
                throw new CherryBusinessException(ErrorCodeEnum.NOT_FOUND);
            case 500:
                throw new CherryBusinessException(ErrorCodeEnum.INTERNAL_SERVER_ERROR);
            default:
                throw new Exception("undefined exception!");

        }
    }

}
