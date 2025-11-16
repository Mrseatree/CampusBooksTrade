package com.Books.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "地区")
@Data
@TableName(value = "region")
public class Region {

    @Schema
    @TableField
    private String id;

    @Schema
    @TableField
    private String name;
}
