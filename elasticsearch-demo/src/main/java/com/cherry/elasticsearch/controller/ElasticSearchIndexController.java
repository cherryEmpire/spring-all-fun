package com.cherry.elasticsearch.controller;

import com.cherry.common.vo.CommonResult;
import com.cherry.elasticsearch.service.ElasticSearchIndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Author: Cherry
 * @Date: 2020/12/7
 * @Desc: ElasticSearchController
 */
@Slf4j
@RestController
@RequestMapping("/elk/index")
@Api("ElasticSearchController: 索引管理")
public class ElasticSearchIndexController {

    private ElasticSearchIndexService elasticSearchIndexService;

    @PostMapping("/createIndex")
    @ApiOperation("创建索引")
    public CommonResult create(@RequestBody String index) {
        return elasticSearchIndexService.createIndex(index);
    }

    @PostMapping("/getIndex")
    @ApiOperation("获取索引")
    public CommonResult get(@RequestBody String index) {
        try {
            boolean exist = elasticSearchIndexService.getIndex(index);
            return new CommonResult().success(exist);
        } catch (IOException e) {
            log.error("获取索引{}失败：", index);
            log.error("获取索引失败:", e);
            return new CommonResult().error("获取索引失败！");
        }
    }

    @PostMapping("/deleteIndex")
    @ApiOperation("删除索引")
    public CommonResult delete(@RequestBody String index) {
        return elasticSearchIndexService.deleteIndex(index);
    }

    @Autowired
    public void setElasticSearchIndexService(ElasticSearchIndexService elasticSearchIndexService) {
        this.elasticSearchIndexService = elasticSearchIndexService;
    }
}
