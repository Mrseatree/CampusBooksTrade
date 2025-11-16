package com.Books.web.app.service.impl;

import com.Books.model.entity.BookService;
import com.Books.web.app.mapper.ServiceMapper;
import com.Books.web.app.service.ServiceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

public class ServiceServiceImpl extends ServiceImpl<ServiceMapper, BookService>
        implements ServiceService {
}
