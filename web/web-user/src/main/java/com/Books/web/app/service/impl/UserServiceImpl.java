package com.Books.web.app.service.impl;

import com.Books.model.entity.User;
import com.Books.web.app.mapper.UserMapper;
import com.Books.web.app.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void updateUserInfo(Long id, String name, String password, String description, String phoneNumber) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getId, id);
        User user = userMapper.selectOne(queryWrapper);
        user.setPassword(password);
        user.setUsername(name);
        user.setPhone(phoneNumber);
        user.setDescription(description);
        userMapper.updateById(user);
    }
}
