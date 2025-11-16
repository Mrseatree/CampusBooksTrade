package com.Books.web.app.vo;

import com.Books.model.enums.NeedStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Schema(description = "我需要列表表项")
public class NeedItemVo{

    @Schema
    private UserVo userVo;

    @Schema
    private String regionName;

    @Schema
    private String title;

    @Schema
    private NeedStatus status;

    @Schema(description = "图片封面")
    private GraphVo graphVo;

    @Schema(description = "发布时间")
    private LocalDateTime createTime;
}
