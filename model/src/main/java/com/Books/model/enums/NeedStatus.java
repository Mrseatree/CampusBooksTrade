package com.Books.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

import java.io.Serializable;

public enum NeedStatus implements BaseEnum{

    SOLVED(0,"已解决"),
    LOOK_FOR(1,"未解决");

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

    NeedStatus(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
