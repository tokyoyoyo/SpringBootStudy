package com.coder.controller;

import com.coder.bean.City;
import com.coder.bean.User;
import com.coder.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    CityService cityService;

    @ResponseBody
    @PostMapping("/city")
    public City saveCity(City city){

        log.info("插入开始");
        cityService.insertCity(city);
        log.info("插入结束");
        return city;
    }

    @ResponseBody
    @PostMapping("/dcity")
    public City deleteCity(long id){

        City city = cityService.getById(id);
        cityService.deleteCityById(id);
        return city;
    }

    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id){
        return cityService.getById(id);
    }

    @ResponseBody
    @GetMapping("/sql")
    public String queryFromDb(){
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account_tbl", Long.class);
        return aLong.toString();
    }

    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session , Model model){

        if(StringUtils.hasLength(user.getName()) && StringUtils.hasLength(user.getPassword())){
            session.setAttribute("loginUser",user);
            return "redirect:/main.html";
        }else {
            model.addAttribute("msg","请输入账号密码");
            return "login";
        }

    }

    @GetMapping("/main.html")
    public String mainPage(HttpSession session , Model model){

       // log.info("当前方法是main（）方法");
//        Object loginUser = session.getAttribute("loginUser");
//
//        if (loginUser != null){
//            return "main";
//        }else {
//            model.addAttribute("msg","请重新登录");
//            return "login";
//        }

        return "main";
    }
}
