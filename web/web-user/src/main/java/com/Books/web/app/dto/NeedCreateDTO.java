package com.Books.web.app.dto;

import lombok.Data;

@Data
public class NeedCreateDTO {

    private Long userid;

    private String title;

    private String serviceType;

    private String region;  // 文本格式，例如 “广东省 广州市”

    private String description;
}
