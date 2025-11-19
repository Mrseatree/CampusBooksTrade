package com.Books.web.app.service.impl;

import com.Books.common.exception.BookException;
import com.Books.common.result.Result;
import com.Books.common.result.ResultCodeEnum;
import com.Books.model.entity.User;
import com.Books.web.app.mapper.UserMapper;
import com.Books.web.app.service.LoginService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Long login(String username, String password) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>();
        queryWrapper.eq(User::getUsername, username);
        User user = userMapper.selectOne(queryWrapper);

        // 用户不存在
        if (user == null) {
            throw new BookException(ResultCodeEnum.LOGIN_USER_NOT_EXITS);
        }

        // 密码错误
        if (!user.getPassword().equals(password)) {
            throw new BookException(ResultCodeEnum.LOGIN_USER_PASSWORD_ERROR);
        }

        // 登录成功 → 返回用户信息
//        UserVo vo = new UserVo();
//        BeanUtils.copyProperties(user, vo);

        return user.getId();
    }
}
