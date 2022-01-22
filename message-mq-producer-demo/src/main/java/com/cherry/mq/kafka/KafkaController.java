package com.cherry.mq.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author : 翁鑫豪
 * @Date : 2022/1/22 21:29
 * @Description: KfkController
 */
@RestController
public class KafkaController {
    @Autowired
    private KafkaService kfkService;

    @GetMapping("/send")
    public String send() {
        kfkService.sendMsg("topic1", "I am topic msg");
        return "success-topic1";
    }
}