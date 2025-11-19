package com.Books.common.result;


import lombok.Getter;

@Getter
public enum ResultCodeEnum {
    SUCCESS(200, "成功"),
    FAIL(201, "失败"),

    NEED_HAS_SERVICE(300,"该需要下已有服务响应"),
    NEED_DOES_NOT_PUBLIC(301,"该需要未发布"),

    LOGIN_USER_NOT_EXITS(400, "用户不存在"),
    LOGIN_USER_PASSWORD_ERROR(401, "密码错误"),

    REGISTER_USER_ALREADY_EXITS(500, "该用户已存在"),;

    private final Integer code;
    private final String message;

    ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
