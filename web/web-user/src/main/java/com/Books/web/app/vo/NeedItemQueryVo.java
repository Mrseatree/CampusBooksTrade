package com.Books.web.app.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
@Schema(description = "我需要-查询实体")
public class NeedItemQueryVo {

    // 地区筛选（用户可选）
    @Schema(description = "省份ID")
    private Long provinceId;

    @Schema(description = "城市ID")
    private Long cityId;

    @Schema(description = "区域ID")
    private Long areaId;

    // 时间范围筛选
    @Schema(description = "开始日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @Schema(description = "结束日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    // 需求状态（如果有）
    @Schema(description = "需求状态")
    private Integer status;

    // 标题/书名/内容关键字搜索
    @Schema(description = "关键字")
    private String keyword;
}


