package com.lijm.demo.jpatest.controller;

import com.lijm.demo.jpatest.entity.Persion;
import com.lijm.demo.jpatest.persionservice.PersionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/p")
@Slf4j
public class PersionController {

    @Autowired
    PersionService persionService;

    @RequestMapping("findByName")
    public Persion getPersion() {
        log.info("给我小红信息");
        System.out.println(persionService.findByName("小红"));
        return persionService.findByName("小红");
    }
}
