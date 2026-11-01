package com.example.service;

import com.example.pojo.Type;
import com.baomidou.mybatisplus.spring.service.IService;
import com.example.utils.Result;

/**
 * @author zhijie
 * @createDate 2026-10-30 17:09:26
 */
public interface TypeService extends IService<Type> {
    Result findAllTypes();
}
