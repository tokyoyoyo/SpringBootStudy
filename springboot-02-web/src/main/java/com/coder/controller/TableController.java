package com.coder.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coder.bean.User;
import com.coder.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.websocket.server.PathParam;
import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;

    @GetMapping("/basic_table")
    public String basic_table(){

        return "table/basic_table";

    }



    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1") Integer pn, Model model){

//        //表格内容的遍历
//        List<User> users = Arrays.asList(new User("张三", "123456"),
//                new User("张四", "123456"),
//                new User("张五", "123456"),
//                new User("张流", "123456"),
//                new User("张七", "123456")
//        );

        //查用户表
        List<User> users = userService.list();
        //model.addAttribute("users",users);

        //分页对象
        Page<User> userPage = new Page<>(pn, 2);

        //分页查询的结果
        Page<User> page = userService.page(userPage, null);


        //信息
        long current = page.getCurrent();
        long pages = page.getPages();
        long total = page.getTotal();
        List<User> records = page.getRecords();

        model.addAttribute("page",page);
        return "table/dynamic_table";
    }


    @GetMapping("/responsive_table")
    public String responsive_table(){

        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table(){

        return "table/editable_table";
    }

    @GetMapping("/user/del/{id}")
    public String deleteUser(@PathVariable("id") long id,
                             @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                             RedirectAttributes ra) {

        userService.removeById(id);

        ra.addAttribute("pn",pn);

        return "redirect:/dynamic_table";
    }



}
