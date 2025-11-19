package com.Books.web.app.controller.user;

import com.Books.common.result.Result;
import com.Books.model.entity.User;
import com.Books.web.app.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
@Tag(name="用户登录")
public class LogInController {

    @Autowired
    private LoginService loginService;

    @Operation(summary = "登录")
    @PostMapping("login")
    public Result login(@RequestParam String username, @RequestParam String password) {
        Long userId=loginService.login(username,password);
        return Result.ok(userId);
    }

}
