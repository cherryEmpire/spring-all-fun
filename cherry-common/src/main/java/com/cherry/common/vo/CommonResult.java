package com.cherry.common.vo;

import com.cherry.common.enums.ErrorCodeEnum;
import com.cherry.common.exception.CherryBusinessException;
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

    public static CommonResult succeed(Object data) {
        CommonResult<Object> commonResult = new CommonResult<>();
        commonResult.success(data);
        return commonResult;
    }

    public static CommonResult succeed(int code, String message, Object data) {
        CommonResult<Object> commonResult = new CommonResult<>();
        commonResult.success(code, message, data);
        return commonResult;
    }

    public static CommonResult defineException(CherryBusinessException exception) {
        CommonResult<Object> commonResult = new CommonResult<>();
        commonResult.error(exception.getCode(), exception.getMessage());
        return commonResult;
    }

    public static CommonResult undefineException(ErrorCodeEnum errorCodeEnum) {
        CommonResult<Object> commonResult = new CommonResult<>();
        commonResult.error(errorCodeEnum.getCode(), errorCodeEnum.getMessage());
        return commonResult;
    }

    public static CommonResult failed(String errorMsg) {
        CommonResult<Object> commonResult = new CommonResult<>();
        commonResult.error(errorMsg);
        return commonResult;
    }

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
        return this.success(200, "SUCCESS", data);
    }

    public CommonResult success(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
        return this;
    }

    public CommonResult error(String errorMsg) {
        return this.error(500, errorMsg);
    }

    public CommonResult error(int code, String errorMsg) {
        this.code = code;
        this.message = StringUtils.isBlank(errorMsg) ? "ERROR" : errorMsg;
        return this;
    }
}
