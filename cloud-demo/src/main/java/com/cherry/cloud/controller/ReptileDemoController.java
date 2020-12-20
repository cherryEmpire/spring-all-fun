package com.cherry.cloud.controller;

import com.cherry.cloud.service.ReptileDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Cherry
 * @Date: 2020/12/6
 * @Desc: JsoupDemoController
 */
@RestController
@RequestMapping("/reptile")
public class ReptileDemoController {

    @Autowired
    private ReptileDemoService reptileDemoService;

    @GetMapping("/jsoup")
    public List<String> jsoup() {
        return reptileDemoService.jsoupList("https://voice.hupu.com/nba/");
    }

    @GetMapping("/httpclient")
    public List<String> httpClient() {
        return reptileDemoService.httpClientList("https://voice.hupu.com/nba/");
    }
}
