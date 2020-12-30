package com.cherry.video.common;

import com.cherry.video.common.enums.FileType;

/**
 * @Author: Cherry
 * @Date: 2020/12/28
 * @Desc: FileDto
 */
public class FileDto {
    private String fileName;

    private long fileLastModify;

    private FileType fileType;

    private long fileSize;

    private String filePath;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileLastModify() {
        return fileLastModify;
    }

    public void setFileLastModify(long fileLastModify) {
        this.fileLastModify = fileLastModify;
    }

    public FileType getFileType() {
        return fileType;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
