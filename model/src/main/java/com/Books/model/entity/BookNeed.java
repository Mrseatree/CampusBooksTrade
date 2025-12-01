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

    @Schema(description = "用户ID")
    @TableField
    private Long userId;

    @Schema(description = "省ID")
    @TableField
    private Long provinceId;

    @Schema(description = "市ID")
    @TableField
    private Long cityId;

//    @Schema(description = "区ID")
//    @TableField
//    private Long areaId;

    @Schema(description = "标题")
    @TableField
    private String title;

    @Schema(description = "描述")
    @TableField
    private String description;

    @Schema(description = "状态")
    @TableField
    private NeedStatus status;

}
