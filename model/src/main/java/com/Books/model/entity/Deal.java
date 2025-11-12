package com.Books.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "已完成的交易")
@TableName(value = "book_deal")
@Data
public class Deal extends BaseEntity{
    private static final long serialVersionUID = 1L;

    @Schema
    @TableField
    private String needId;

    @Schema
    @TableField
    private String serviceId;
}
