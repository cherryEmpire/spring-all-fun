package com.cherry.email.service.impl;

import com.cherry.common.vo.CommonResult;
import com.cherry.email.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @Author: Cherry
 * @Date: 2020/12/20
 * @Desc: EmailServiceImpl
 */
@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.email.username}")
    private String from;

    /**
     * 发送纯文本邮件
     *
     * @param to      邮件接收方
     * @param subject 邮件主题
     * @param text    邮件内容
     */
    @Override
    public CommonResult sendTextMail(String to, String subject, String text) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(from);
        simpleMailMessage.setTo(to);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(text);

        try {
            javaMailSender.send(simpleMailMessage);
            logger.info("邮件已发送。");
            return CommonResult.succeed("邮件已发送。");
        } catch (Exception e) {
            logger.error("邮件发送失败。" + e.getMessage());
            return CommonResult.failed("邮件发送失败。");
        }
    }

    /**
     * 发送带附件的邮件
     *
     * @param to      邮件接收方
     * @param subject 邮件主题
     * @param text    邮件内容
     * @param path    附件所在的文件路径
     */
    @Override
    public CommonResult sendAttachmentMail(String to, String subject, String text, String path) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            // 创建一个multipart格式的message
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            messageHelper.setText(text, true);
            // &#x6DFB;&#x52A0;&#x9644;&#x4EF6;&#x4FE1;&#x606F;
            FileSystemResource file = new FileSystemResource(new File(path));
            String fileName = path.substring(path.lastIndexOf(File.separator));
            messageHelper.addAttachment(fileName, file);
            // 发送带附件的邮件
            javaMailSender.send(mimeMessage);
            logger.info("邮件发送成功");
            return CommonResult.succeed("邮件发送成功");
        } catch (Exception e) {
            logger.error("带有附件的邮件发送失败。" + e.getMessage());
            return CommonResult.failed("带有附件的邮件发送失败。");
        }
    }
}
