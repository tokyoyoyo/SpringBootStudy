package com.coder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
@MapperScan("com/coder/mapper")
public class Springboot02WebApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot02WebApplication.class, args);
    }

}