package com.Books.web.app.service;

import com.Books.model.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

public interface UserService extends IService<User> {
    void updateUserInfo(Long id, String name, String password, String description, String phoneNumber);
}
