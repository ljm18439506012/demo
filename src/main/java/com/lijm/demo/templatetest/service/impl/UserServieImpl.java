package com.lijm.demo.templatetest.service.impl;

import com.lijm.demo.templatetest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
@Service
@Slf4j
public class UserServieImpl implements UserService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 增加一个用户
     *
     * @param name
     * @param age
     */
    @Override
    public void create(String name, Integer age) {
        log.info("我接收到的是："+age);
        jdbcTemplate.update("insert into user(name, age) values(?, ?)", name, age);
    }

    /**
     * 根据name删除一个用户
     *
     * @param name
     */
    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("delete * from user where name = ?", name);
    }

    /**
     * 获取用户总数
     */
    @Override
    public Integer getAllUsers() {
        jdbcTemplate.queryForObject("select count(id) from user", Integer.class);
        return null;
    }

    /**
     * 删除所有用户
     */
    @Override
    public void clearAllUsers() {
        jdbcTemplate.update("delete * from user");
    }
}
