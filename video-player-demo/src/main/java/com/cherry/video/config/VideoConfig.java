package com.cherry.video.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Cherry
 * @Date: 2020/12/27
 * @Desc: VideoConfig
 */
@Configuration
public class VideoConfig {

    public static final String prefix = "\\project";
    @Value("${fileroot}")
    private String rootPath;

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

}
