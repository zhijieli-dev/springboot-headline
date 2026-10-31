package com.example.service;

import com.example.pojo.User;
import com.baomidou.mybatisplus.spring.service.IService;
import com.example.utils.Result;

/**
 * @author zhijie
 * @createDate 2026-10-30 17:09:26
 */
public interface UserService extends IService<User> {
    Result login(User user);
    Result getUserInfo(String token);
    Result checkUserName(String username);
    Result register(User user);
}
