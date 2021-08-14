package com.coder.config;

import com.coder.interceptor.LoginInterceptor;
import com.coder.interceptor.RedisUrlCountInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AdminWebConfig implements WebMvcConfigurer {

//    @Autowired
//    RedisUrlCountInterceptor redisUrlCountInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {


        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")  //所有请求都被拦截包括静态资源
                .excludePathPatterns("/","/login","/css/**",
                        "/fonts/**","/images/**","/js/**"); //放行的请求

//        registry.addInterceptor( redisUrlCountInterceptor )
//                .addPathPatterns("/**")
//                .excludePathPatterns("/","/login","/css/**",
//                        "/fonts/**","/images/**","/js/**"); //放行的请求
    }
}
