package com.cherry.elasticsearch.service;

import cn.hutool.core.lang.UUID;
import com.alibaba.fastjson.JSON;
import com.cherry.common.vo.CommonResult;
import com.cherry.elasticsearch.vo.ELKDocumentResponse;
import com.cherry.elasticsearch.vo.ELKDocumentVo;
import com.cherry.elasticsearch.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Author: Cherry
 * @Date: 2020/12/8
 * @Desc: ElasticSearchDocumentService
 */
@Slf4j
@Service
public class ElasticSearchDocumentService {

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public CommonResult createDocument(ELKDocumentVo documentVo) {
        log.info("开始文档创建：{}", documentVo);
        IndexRequest indexRequest = new IndexRequest(documentVo.getIndex());
        User user = documentVo.getUser();
        IndexRequest source = indexRequest.source(JSON.toJSONString(user), XContentType.JSON);
        try {
            IndexResponse index = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
            ELKDocumentResponse response = new ELKDocumentResponse();
            response.setStatus(index.status().toString());
            response.setData(documentVo);
            log.info("文档创建成功！");
            return new CommonResult<>().success(response);
        } catch (IOException e) {
            log.error("文档创建失败：", e);
            return new CommonResult<>().error("error");
        }
    }

    public CommonResult updateDocument(ELKDocumentVo documentVo) {
        log.info("开始文档更新：{}", documentVo);
        UpdateRequest updateRequest = new UpdateRequest(documentVo.getIndex(), UUID.fastUUID().toString());
        User user = documentVo.getUser();
        updateRequest.doc(JSON.toJSONString(user), XContentType.JSON);
        UpdateResponse update = null;
        try {
            update = restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
            ELKDocumentResponse response = new ELKDocumentResponse();
            response.setStatus(update.status().toString());
            response.setData(documentVo);
            log.info("文档更新成功！");
            return new CommonResult<>().success(response);
        } catch (IOException e) {
            log.error("文档更新失败：", e);
            return new CommonResult<>().error("error");
        }
    }

    public CommonResult getDocument(String index, String docId) {
        //testapi 索引中     是否存在 1 的文档
        log.info("查询索引{}中是否存在文档{}", index, docId);
        GetRequest existsRequest = new GetRequest(index, docId);
        try {
            boolean exists = restHighLevelClient.exists(existsRequest, RequestOptions.DEFAULT);
            log.info("查询成功！");
            return new CommonResult().success(exists);
        } catch (IOException e) {
            log.error("查询失败:", e);
            return new CommonResult().error("查询失败！");
        }
    }

    public CommonResult listDocuments(String index) {
        GetRequest getRequest = new GetRequest(index, UUID.fastUUID().toString());
        try {
            GetResponse documentFields = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
            return new CommonResult().success("success");
        } catch (IOException e) {
            log.error("查询失败:", e);
            return new CommonResult().error("查询失败！");
        }
    }

    public CommonResult deleteDocument(String index) {
        log.info("开始删除索引{}中文档！");
        DeleteRequest deleteRequest = new DeleteRequest(index, UUID.fastUUID().toString());
        try {
            DeleteResponse delete = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
            return new CommonResult().success("success");
        } catch (IOException e) {
            return new CommonResult().error("删除失败！");
        }
    }

    public CommonResult searchDocument(String index, String fieldName, String queryKey) {
        SearchRequest searchRequest = new SearchRequest(index);
        //匹配字段
        MatchQueryBuilder matchQueryBuilder = QueryBuilders.matchQuery(fieldName, queryKey);
        //构建查询器
        searchRequest.source(new SearchSourceBuilder().query(matchQueryBuilder));
        try {
            SearchResponse searchResponse = restHighLevelClient.search(searchRequest, RequestOptions.DEFAULT);
            return new CommonResult().success("success");
        } catch (IOException e) {
            return new CommonResult().success("success");
        }
    }
}
