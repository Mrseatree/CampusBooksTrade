package com.Books.web.app.controller.user;

import com.Books.common.result.Result;
import com.Books.web.app.service.RegisterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/app")
@Tag(name="用户注册")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @Operation(summary = "注册")
    @PostMapping("register")
    public Result register(@RequestParam String username, @RequestParam String password) {
        registerService.registerForNewUser(username,password);
        return Result.ok();
    }
}
