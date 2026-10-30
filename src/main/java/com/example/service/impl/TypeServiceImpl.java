package com.example.service.impl;

import com.baomidou.mybatisplus.spring.service.impl.ServiceImpl;
import com.example.pojo.Type;
import com.example.service.TypeService;
import com.example.mapper.TypeMapper;
import org.springframework.stereotype.Service;

/**
 * @author zhijie
 * @createDate 2026-10-30 17:09:26
 */
@Service
public class TypeServiceImpl extends ServiceImpl<TypeMapper, Type>
    implements TypeService{

}




