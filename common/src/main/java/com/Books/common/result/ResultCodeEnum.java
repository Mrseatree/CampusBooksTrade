package com.Books.common.result;


import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    SUCCESS(200, "成功"),
    FAIL(201, "失败"),

    NEED_HAS_SERVICE(301,"该需要下已有服务响应"),
    NEED_DOES_NOT_PUBLIC(302,"该需要未发布"),;

    private final Integer code;
    private final String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
