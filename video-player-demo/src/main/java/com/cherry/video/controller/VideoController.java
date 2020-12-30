package com.cherry.video.controller;

import cn.hutool.core.net.URLDecoder;
import com.cherry.video.service.VideoService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * @Author: Cherry
 * @Date: 2020/12/27
 * @Desc: VideoController
 */
@Controller
@Slf4j
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping(value = "/video/play/{fileName}")
    public void videoPlay(@PathVariable(value = "fileName") String fileName, HttpServletRequest request, HttpServletResponse response) {
        try {
            videoService.fileChunkDownload(new String(URLDecoder.decode(Base64.getDecoder().decode(fileName)), "UTF-8"), request, response);
        } catch (UnsupportedEncodingException e) {
            log.error("地址解析错误------->", e);
        }
    }

}
