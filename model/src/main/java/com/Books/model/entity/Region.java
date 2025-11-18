package com.Books.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "地区")
@Data
@TableName(value = "region")
public class Region extends BaseEntity{

    @Schema(description = "地区名称")
    @TableField
    private String name;

    @Schema(description = "上一级ID，省的 parent_id = 0")
    @TableField
    private Long parentId;

    @Schema(description = "层级：1=省，2=市，3=区")
    @TableField
    private Integer level;
}
