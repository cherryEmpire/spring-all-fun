package com.cherry.elasticsearch.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Cherry
 * @Date: 2020/12/8
 * @Desc: ELKDocumentVo
 */
@Data
@NoArgsConstructor
public class ELKDocumentVo {

    private String index;

    private User user;

    public ELKDocumentVo(String index, User user) {
        this.index = index;
        this.user = user;
    }
}
