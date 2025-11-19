package com.Books.web.app.service.impl;

import com.Books.common.exception.BookException;
import com.Books.common.result.ResultCodeEnum;
import com.Books.model.entity.User;
import com.Books.web.app.mapper.UserMapper;
import com.Books.web.app.service.RegisterService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;

public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void registerForNewUser(String username, String password) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        User user = userMapper.selectOne(queryWrapper);
        if (user != null) {
            throw new BookException(ResultCodeEnum.REGISTER_USER_ALREADY_EXITS);
        }

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(password);
        userMapper.insert(newUser);
    }
}
