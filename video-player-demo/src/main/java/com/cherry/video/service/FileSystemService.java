package com.cherry.video.service;

import com.cherry.video.common.FileDto;
import com.cherry.video.common.FileNode;
import com.cherry.video.common.enums.FileType;
import com.cherry.video.config.VideoConfig;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Cherry
 * @Date: 2020/12/28
 * @Desc: FileSystemService
 */
@Service
public class FileSystemService {

    @Autowired
    private VideoConfig videoConfig;

    public List<FileDto> getRoot() {
        return getFiles(null);
    }

    public List<FileDto> getFiles(String path) {
        if (StringUtils.isBlank(path)) {
            path = videoConfig.getRootPath();
        } else {
            if (path.startsWith(VideoConfig.prefix)) {
                path = path.substring(VideoConfig.prefix.length());
            }
            path = videoConfig.getRootPath() + '\\' + path;
        }
        File f = new File(path);
        if (f.exists()) {
            List<FileDto> flist = new ArrayList<>(10);
            if (f.isDirectory()) {
                File[] files = f.listFiles();
                if (files != null) {
                    File temp = null;
                    for (int i = 0, len = files.length; i < len; i++) {
                        temp = files[i];
                        FileDto fileDto = new FileDto();
                        fileDto.setFileName(temp.getName());
                        fileDto.setFileLastModify(temp.lastModified());
                        if (temp.isDirectory()) {
                            fileDto.setFileType(FileType.DIR);
                        } else {
                            fileDto.setFileType(FileType.FILE);
                            fileDto.setFileSize(temp.length());
                        }
                        fileDto.setFilePath("\\project" + temp.getPath().substring(videoConfig.getRootPath().length() - 4));
                        flist.add(fileDto);
                    }
                }
            }
            return flist;
        }
        return new ArrayList<>();
    }

    public List<FileNode> getAll() {
        String rootPath = videoConfig.getRootPath();
        return listDir(rootPath);
    }

    private List<FileNode> listDir(String path) {
        File file = new File(path);
        File[] files = file.listFiles();
        List<FileNode> flist = new ArrayList<>(10);
        if (files != null) {
            File temp = null;
            for (int i = 0, len = files.length; i < len; i++) {
                temp = files[i];
                FileNode fileNode = getFile(temp);
                if(temp.isDirectory()) {

                }
                flist.add(fileNode);
            }
        }
        return flist;
    }

    private FileNode getFile(File file) {
        FileNode fileDto = new FileNode();
        fileDto.setFileName(file.getName());
        fileDto.setFileLastModify(file.lastModified());
        if (file.isDirectory()) {
            fileDto.setFileType(FileType.DIR);
        } else {
            fileDto.setFileType(FileType.FILE);
            fileDto.setFileSize(file.length());
        }
        if(file.isDirectory()) {
            File[] files = file.listFiles();
            List<FileNode> flist = new ArrayList<>(10);
            if (files != null) {
                File temp = null;
                for (int i = 0, len = files.length; i < len; i++) {
                    temp = files[i];
                    FileNode fileNode = getFile(temp);
                    if(temp.isDirectory()) {

                    }
                    flist.add(fileNode);
                }
            }
        }
        fileDto.setFilePath("\\project" + file.getPath().substring(videoConfig.getRootPath().length() - 4));
        return fileDto;
    }

}
