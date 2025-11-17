package com.Books.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;

public class Graph {
    @TableField
    private  String needId;

    @TableField
    private String url;

    @TableField
    private String name;

    @TableField
    private int isCover;
}
