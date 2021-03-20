package com.cherry.fastdfs.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * @Author: Cherry
 * @Date: 2021/3/20
 * @Desc: FastDFSSerivceTest
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class FastDFSServiceTest {

    @Test
    public void Upload() {
        String fileUrl = this.getClass().getResource("/test.jpg").getPath();
        File file = new File(fileUrl);
        String str = FastDFSService.uploadFile(file);
        FastDFSService.getResAccessUrl(str);
    }

    @Test
    public void Delete() {
        FastDFSService.deleteFile("group1/M00/00/00/wKg4A2BVwrSAVgrQABCii0A-5Jg586.jpg");
    }
}
