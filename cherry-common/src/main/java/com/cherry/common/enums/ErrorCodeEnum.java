package com.cherry.common.enums;

/**
 * @Author: Cherry
 * @Date: 2021/3/22
 * @Desc: ErrorCodeEnum
 */
public enum ErrorCodeEnum {

    SUCCESS(200, "成功！"),
    NO_PERMISSION(403, "无权限！"),
    NO_AUTH(401, "未登录！"),
    NOT_FOUND(404, "未找到该资源！"),
    INTERNAL_SERVER_ERROR(500, "服务器内部异常，请联系管理员！");

    private Integer code;

    private String message;

    ErrorCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "【" + code + "】" + "：" + message;
    }
}
