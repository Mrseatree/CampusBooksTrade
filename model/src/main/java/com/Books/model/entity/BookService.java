package com.Books.model.entity;

import com.Books.model.enums.ServiceStatus;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "针对需求提出的服务，可出售的教材")
@Data
@TableName(value = "book_service")
public class BookService extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Schema
    @TableField
    private String needId;

    @Schema
    @TableField
    private String userId;

    @Schema
    @TableField
    private String description;

    @Schema
    @TableField
    private double price;

    @Schema
    @TableField
    private ServiceStatus status;
}
