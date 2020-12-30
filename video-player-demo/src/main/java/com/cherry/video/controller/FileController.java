package com.cherry.video.controller;

import com.cherry.video.common.FileDto;
import com.cherry.video.service.FileSystemService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: Cherry
 * @Date: 2020/12/27
 * @Desc: FileController
 */
@RestController
public class FileController {

    @Autowired
    private FileSystemService fileSystemService;

    @GetMapping("/root")
    @ResponseBody
    public List<FileDto> root() {
        return fileSystemService.getRoot();
    }

    @GetMapping("/project")
    @ResponseBody
    public List<FileDto> listFiles(HttpServletRequest request) {
        String path = request.getHeader("PATH");
        if (StringUtils.isBlank(path)) {
            return fileSystemService.getRoot();
        }
        return fileSystemService.getFiles(path);
    }
}
