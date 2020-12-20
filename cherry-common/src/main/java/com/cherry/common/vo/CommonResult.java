package com.cherry.common.vo;

import org.apache.commons.lang3.StringUtils;

/**
 * @Author: Cherry
 * @Date: 2020/12/8
 * @Desc: CommonResult
 */
public class CommonResult<T> {

    private int code;

    private String message;

    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public CommonResult success(T data) {
        this.code = 200;
        this.message = "SUCCESS";
        this.data = data;
        return this;
    }

    public CommonResult error(String errorMsg) {
        this.code = 500;
        this.message = StringUtils.isBlank(errorMsg) ? "ERROR" : errorMsg;
        return this;
    }

    public static CommonResult succeed(Object data) {
        CommonResult<Object> commonResult = new CommonResult<>();
        commonResult.success(data);
        return commonResult;
    }

    public static CommonResult failed(String errorMsg) {
        CommonResult<Object> commonResult = new CommonResult<>();
        commonResult.error(errorMsg);
        return commonResult;
    }
}
