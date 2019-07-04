package com.lijm.demo.templatetest.controller;

import com.lijm.demo.templatetest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author Administrator
 */
@Controller
@Slf4j
public class UserControllerL {

    @Autowired
    UserService userService;
    /**
     * 添加一个用户
     * @param name
     * @param age
     * @return
     */
    @ResponseBody
    @PostMapping("/create")
    public String create(String name, Integer age) {
        log.info("姓名："+name);
        log.info("年龄："+age);
        userService.create(name, age);
        return "success";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }
}
