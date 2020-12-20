package com.cherry.elasticsearch.controller;

import com.cherry.common.vo.CommonResult;
import com.cherry.elasticsearch.service.ElasticSearchDocumentService;
import com.cherry.elasticsearch.vo.ELKDocumentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Cherry
 * @Date: 2020/12/8
 * @Desc: ElasticSearchDocumentController
 */
@RestController
@RequestMapping("/elk/doc")
@Api("ElasticSearchDocumentController: 文档管理")
public class ElasticSearchDocumentController {

    private ElasticSearchDocumentService elasticSearchDocumentService;

    @PostMapping("/createDoc")
    @ApiOperation("创建文档")
    public CommonResult create(@RequestBody ELKDocumentVo documentVo) {
        return elasticSearchDocumentService.createDocument(documentVo);
    }

    @PostMapping("/updateDoc")
    @ApiOperation("更新文档")
    public CommonResult update(@RequestBody ELKDocumentVo documentVo) {
        return elasticSearchDocumentService.updateDocument(documentVo);
    }

    @PostMapping("/getDoc")
    @ApiOperation("获取文档")
    public CommonResult get(@RequestBody String index, @RequestBody String docId) {
        return elasticSearchDocumentService.getDocument(index, docId);
    }

    @PostMapping("/listDocs")
    @ApiOperation("列出文档")
    public CommonResult list(@RequestBody String index) {
        return elasticSearchDocumentService.listDocuments(index);
    }

    @PostMapping("/deleteDoc")
    @ApiOperation("删除文档")
    public CommonResult delete(@RequestBody String index) {
        return elasticSearchDocumentService.deleteDocument(index);
    }

    @PostMapping("/searchDoc")
    @ApiOperation("查询文档")
    public CommonResult search(@RequestBody String index, String fieldName, String queryKey) {
        return elasticSearchDocumentService.searchDocument(index, fieldName, queryKey);
    }

    @Autowired
    public void setElasticSearchDocumentService(ElasticSearchDocumentService elasticSearchDocumentService) {
        this.elasticSearchDocumentService = elasticSearchDocumentService;
    }
}
