package com.cherry.video.config;

import com.cherry.video.common.FileDto;
import com.cherry.video.common.Video;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Cherry
 * @Date: 2020/12/27
 * @Desc: VideoConfig
 */
@Configuration
public class VideoConfig {

    @Value("${fileroot}")
    private String rootPath;

    public static final String prefix = "\\project";

    public String getRootPath() {
        return rootPath;
    }

    public void setRootPath(String rootPath) {
        this.rootPath = rootPath;
    }

}
