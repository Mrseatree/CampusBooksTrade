package com.Books.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("need_book_image")
public class NeedBookImage {
    private Long id;
    private Long needId;
    private String url;
    private Integer sortOrder;
}

