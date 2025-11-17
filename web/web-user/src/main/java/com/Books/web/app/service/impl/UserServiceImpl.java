package com.Books.web.app.service.impl;

import com.Books.model.entity.User;
import com.Books.web.app.mapper.UserMapper;
import com.Books.web.app.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
}
