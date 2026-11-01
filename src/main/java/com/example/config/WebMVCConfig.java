package com.example.config;

import com.example.interceptors.LoginProtectedInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Configuration for registering application interceptors
@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    @Autowired
    private LoginProtectedInterceptor loginProtectedInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // Protect all headline endpoints
        registry.addInterceptor(loginProtectedInterceptor)
                .addPathPatterns("/headline/**");
    }
}