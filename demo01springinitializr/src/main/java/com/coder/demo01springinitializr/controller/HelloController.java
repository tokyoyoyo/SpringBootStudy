package com.coder.demo01springinitializr.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam("name") String name){
        log.info("请求进来了……");
        return "Hello, Spring Boot 2!"+"你好："+name;
    }
}
