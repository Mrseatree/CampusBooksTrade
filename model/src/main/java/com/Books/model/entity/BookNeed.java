package com.Books.model.entity;

import com.Books.model.enums.NeedStatus;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;


@Schema(description = "教材需求表")
@TableName(value = "book_need")
@Data
public class BookNeed extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Schema
    @TableField
    private String userId;

    @Schema
    @TableField
    private String regionId;

    @Schema
    @TableField
    private String title;

//    @Schema
//    @TableField
//    private String author;

    @Schema
    @TableField
    private String description;

    @Schema
    @TableField
    private NeedStatus status;

    @Schema
    @TableField
    private String createTime;



}
