package com.Books.web.app.controller.user;


import com.Books.common.result.Result;
import com.Books.model.entity.User;
import com.Books.web.app.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/user")
@Tag(name="个人中心")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary="修改个人信息",description = "修改个人信息")
    @PostMapping("update")
    public Result updateUserInfo(
            @RequestParam Long userId,
            @RequestParam String password,
            @RequestParam String introduction,
            @RequestParam String phoneNumber) {
        userService.updateUserInfo(userId,password,introduction,phoneNumber);
        return Result.ok();
    }

    @Operation(summary = "查找用户信息",description = "根据用户id查找用户信息")
    @PostMapping("get")
    public Result getUserInfo(@RequestParam Long userId) {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getId, userId);
        User user = userService.getOne(queryWrapper);
        return Result.ok(user);
    }

}
