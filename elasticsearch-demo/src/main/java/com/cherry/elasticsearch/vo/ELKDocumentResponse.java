package com.cherry.elasticsearch.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Cherry
 * @Date: 2020/12/8
 * @Desc: ELKDocumentResponse
 */
@Data
@NoArgsConstructor
public class ELKDocumentResponse {

    private String status;

    private ELKDocumentVo data;

    public ELKDocumentResponse(String status, ELKDocumentVo data) {
        this.status = status;
        this.data = data;
    }
}
