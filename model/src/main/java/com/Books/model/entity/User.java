package com.Books.model.entity;

import com.Books.model.enums.UserType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Schema(description = "用户及管理员信息")
@TableName(value = "user")
@Data
public class User extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;
//    @TableId(type = IdType.AUTO)
//    private Long id;

    @Schema(description = "用户名")
    @TableField
    private String username;

    @Schema(description = "密码")
    @TableField
    private String password;

    @Schema(description = "电话号码")
    @TableField
    private String phone;

    @Schema(description = "用户类型")
    @TableField
    private UserType userType;

    @Schema(description = "注册时间")
    @TableField
    private Date registerDate;

    @Schema(description = "头像")
    @TableField
    private String avatar_url;
}
