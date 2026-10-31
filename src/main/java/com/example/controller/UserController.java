package com.example.controller;

import com.example.pojo.User;
import com.example.service.UserService;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {

    // Service that handles user operations
    @Autowired
    private UserService userService;

    // User login
    @PostMapping("login")
    public Result login(@RequestBody User user) {
        return userService.login(user);
    }

    // Retrieve user information
    @GetMapping("getUserInfo")
    public Result getUserInfo(@RequestBody String token) {
        return userService.getUserInfo(token);
    }

    // Check if the username is already taken
    @PostMapping("checkUserName")
    public Result checkUserName(String username) {
        return userService.checkUserName(username);
    }

    // Register a new user
    @PostMapping("register")
    public Result register(@RequestBody User user) {
        return userService.register(user);
    }
}