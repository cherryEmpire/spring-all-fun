package com.cherry.sms.controller;

import com.aliyuncs.CommonResponse;
import com.aliyuncs.exceptions.ClientException;
import com.cherry.sms.service.SmsService;
import com.cherry.sms.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Cherry
 * @Date: 2020/12/26
 * @Desc: SmsController
 */
@RestController
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    private SmsService smsService;

    /**
     * 发送短信
     *
     * @param phone
     * @param request
     * @return
     */
    @GetMapping(value = "/sendSms")
    @ResponseBody
    public Map<String, Object> sendSms(String phone, HttpServletRequest request) throws ClientException {
        Map<String, Object> map = new HashMap<>();
        // 验证码（指定长度的随机数）
        String code = CodeUtil.generateVerifyCode(6);
        String TemplateParam = "{\"code\":\"" + code + "\"}";
        // 短信模板id
        String TemplateCode = "SMS_152440521";
        CommonResponse response = smsService.sendSms(phone, TemplateParam, TemplateCode);
        map.put("verifyCode", code);
        map.put("phone", phone);
        request.getSession().setAttribute("CodePhone", map);
        return map;
    }
}
