package com.Books.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum UserType implements BaseEnum{
    ADMIN(1,"管理员"),
    USER(0,"用户");

    @EnumValue
    @JsonValue
    private int code;
    private String name;

    @Override
    public Integer getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }

    UserType(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
