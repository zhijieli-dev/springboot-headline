package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import com.example.utils.JwtHelper;
import com.example.utils.Result;
import com.example.utils.ResultCodeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtHelper jwtHelper;

    @PostMapping("login")
    public Result login(@RequestBody User user) {
        return userService.login(user);
    }

    @GetMapping("getUserInfo")
    public Result getUserInfo(@RequestHeader String token) {
        return userService.getUserInfo(token);
    }

    @PostMapping("checkUserName")
    public Result checkUserName(String username) {
        return userService.checkUserName(username);
    }

    @PostMapping("register")
    public Result register(@RequestBody User user) {
        return userService.register(user);
    }

    // Check whether the user's JWT token is still valid
    @GetMapping("checkLogin")
    public Result checkLogin(@RequestHeader String token) {
        boolean expiration = jwtHelper.isExpiration(token);

        if (expiration) {
            return Result.build(null, ResultCodeEnum.NOTLOGIN);
        }

        return Result.ok(null);
    }
}