package com.cherry.elasticsearch.service;

import com.cherry.common.vo.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @Author: Cherry
 * @Date: 2020/12/8
 * @Desc: ElasticSearchIndexService
 */
@Slf4j
@Service
public class ElasticSearchIndexService {

    private RestHighLevelClient restHighLevelClient;

    public CommonResult<String> createIndex(String index) {
        //创建请求
        CreateIndexRequest request = new CreateIndexRequest(index);
        try {
            if (this.getIndex(index) == true) {
                log.info("索引创建失败，索引{}已存在", index);
                return new CommonResult<String>().error("索引创建失败，索引已存在！");
            }
            CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(request, RequestOptions.DEFAULT);
            log.info("索引{}创建成功！", index);
            return new CommonResult<String>().success("索引创建成功！");
        } catch (IOException e) {
            log.error("索引{}创建失败：", index);
            log.error("索引创建失败:", e);
            return new CommonResult<String>().error(e.getMessage());
        }
    }

    public boolean getIndex(String index) throws IOException {
        GetIndexRequest request = new GetIndexRequest(index);
        return restHighLevelClient.indices().exists(request, RequestOptions.DEFAULT);
    }

    public CommonResult<String> deleteIndex(String index) {
        DeleteIndexRequest deleteIndexRequest = new DeleteIndexRequest(index);
        try {
            AcknowledgedResponse delete = restHighLevelClient.indices().delete(deleteIndexRequest, RequestOptions.DEFAULT);
            log.info("索引{}删除成功！", index);
            return new CommonResult<String>().success("索引删除成功！");
        } catch (IOException e) {
            log.error("索引{}删除失败：", index);
            log.error("索引删除失败:", e);
            return new CommonResult<String>().error(e.getMessage());
        }
    }

    @Autowired
    public void setRestHighLevelClient(RestHighLevelClient restHighLevelClient) {
        this.restHighLevelClient = restHighLevelClient;
    }
}
