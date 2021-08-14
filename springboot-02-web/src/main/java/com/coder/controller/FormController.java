package com.coder.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
@Slf4j
public class FormController {

    @GetMapping("/form_layouts")
    public String form_layouts(){

        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("userName") String username,
                         @RequestPart("headerImage") MultipartFile headerImage,
                         @RequestPart("photos") MultipartFile[] photos
                         ) throws IOException {

        log.info("上传的信息：\n" +
                        "email={}\n" +
                        "username={}\n" +
                        "headerImg={}\n" +
                        "photos={}",
                email,username,headerImage.getSize(),photos.length);

        if(!headerImage.isEmpty()){
            //保存到文件服务器，OSS服务器
            String originalFilename = headerImage.getOriginalFilename();
            headerImage.transferTo(new File("D:\\cache\\"+originalFilename));
        }

        if(photos.length > 0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\cache\\"+originalFilename));
                }
            }
        }

        return "main";
    }
}
