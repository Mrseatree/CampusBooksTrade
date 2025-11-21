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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/user")
@Tag(name="个人中心")
public class UserController {

    @Autowired
    private UserService userService;

    @Operation(summary="修改个人信息",description = "修改个人信息")
    @PostMapping("update")
    public Result updateUserInfo(Long id,String name,String password,String description,String phoneNumber) {
        userService.updateUserInfo(id,name,password,description,phoneNumber);
        return Result.ok();
    }
}
