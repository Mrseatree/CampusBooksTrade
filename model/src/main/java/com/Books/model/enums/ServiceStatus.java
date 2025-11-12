package com.Books.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public enum ServiceStatus implements BaseEnum{
    ACCEPTED(1,"成交"),
    WAIT_FOR(0,"等待答复"),
    UNAVAILABLE(-1,"未成交");

    @JsonValue
    @EnumValue
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

    ServiceStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
