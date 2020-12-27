package com.cherry.email.controller;

import com.cherry.common.vo.CommonResult;
import com.cherry.email.service.EmailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Cherry
 * @Date: 2020/12/20
 * @Desc: EmailController
 */
@RestController
@RequestMapping("/email")
@Api(tags = "邮件发送服务")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    @ApiOperation(tags = "发送不带附件的邮件", value = "发送不带附件的邮件")
    public CommonResult send(String to, String subject, String text) {
        return emailService.sendTextMail(to, subject, text);
    }
}
