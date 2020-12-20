package com.cherry.email.service;

import com.cherry.common.vo.CommonResult;

/**
 * @Author: Cherry
 * @Date: 2020/12/20
 * @Desc: EmailService
 */
public interface EmailService {

    CommonResult sendTextMail(String to, String subject, String text);

    CommonResult sendAttachmentMail(String to, String subject, String text, String path);
}
