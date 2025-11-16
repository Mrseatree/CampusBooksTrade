package com.Books.web.app.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "用户栏信息")
public class UserVo {
    @Schema(description = "用户昵称")
    private String name;

    @Schema(description = "用户头像")
    private String avatarUrl;
}
