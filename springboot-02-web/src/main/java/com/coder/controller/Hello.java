package com.coder.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a")
public class Hello {

    @GetMapping("/hello")
    @ResponseBody
    public String hello(){
        return "helloH";
    }

}
