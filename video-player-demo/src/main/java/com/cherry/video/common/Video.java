package com.cherry.video.common;

import java.io.Serializable;

/**
 * @Author: Cherry
 * @Date: 2020/12/27
 * @Desc: Video
 */
public class Video implements Serializable {
    private Integer id;
    private String type;
    private String path;
    private String title;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", path='" + path + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
