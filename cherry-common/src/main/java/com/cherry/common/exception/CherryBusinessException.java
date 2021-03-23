package com.cherry.common.exception;

import com.cherry.common.enums.ErrorCodeEnum;

/**
 * @Author: Cherry
 * @Date: 2021/3/22
 * @Desc: CherryBusinessException
 */
public class CherryBusinessException extends RuntimeException {

    protected Integer code;

    protected String message;

    public CherryBusinessException(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public CherryBusinessException(ErrorCodeEnum errorCodeEnum) {
        super();
        this.code = errorCodeEnum.getCode();
        this.message = errorCodeEnum.getMessage();
    }

    public CherryBusinessException() {
        super();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
