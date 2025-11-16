package com.Books.web.app.vo;

import com.Books.model.entity.BookNeed;
import com.Books.model.enums.NeedStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Schema(description = "我需要详情页实体")
public class NeedDetailVo{

    @Schema
    private UserVo userVo;

    @Schema
    private String regionName;

    @Schema
    private String title;

    @Schema
    private String description;

    @Schema
    private NeedStatus status;

    @Schema(description = "图片列表")
    private List<GraphVo> graphVoList;

    @Schema(description = "我服务响应列表")
    private List<ServiceVo> serviceVoList;

    @Schema(description = "发布时间")
    private LocalDateTime createTime;
}
