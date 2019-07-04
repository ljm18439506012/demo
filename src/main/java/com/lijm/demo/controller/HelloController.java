package com.lijm.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * 用于处理security的跳转页面请求
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/login")
    public String login(){
        System.out.println("我进去了");
        return "login";
    }

//    @PostMapping("/login")
//    public String login(){
//        return "login";
//    }
//    @PostMapping("/logout")
//    public String toLogin(){
//        return "logout";
//    }
}
