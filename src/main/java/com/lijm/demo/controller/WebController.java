package com.lijm.demo.controller;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
@Slf4j
public class WebController {

    @RequestMapping("hello")
    public String hello() throws Exception {
        log.info("我要一个对手");
        throw new Exception("发生错误");
    }
}
