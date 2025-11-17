package com.Books.model.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import com.fasterxml.jackson.annotation.JsonValue;

public enum NeedStatus implements BaseEnum{

    PUBLIC(0,"已发布"),
    CANCELED(-1,"已取消");


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
