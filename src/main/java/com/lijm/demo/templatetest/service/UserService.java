package com.lijm.demo.templatetest.service;

public interface UserService {
    /**
     * 增加一个用户
     * @param name
     * @param age
     */
    void create(String name,Integer age);

    /**
     * 根据name删除一个用户
     * @param name
     */
    void deleteByName(String name);

    /**
     * 获取用户总数
     */
    Integer getAllUsers();

    /**
     * 删除所有用户
     */
    void clearAllUsers();
}
