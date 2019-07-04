package com.lijm.demo.cache;

import com.lijm.demo.jpatest.entity.Persion;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class ChcacheTestTest {

    @Autowired
    ChcacheTest chcacheTest;

    @Test
    public void findbyname() {
        Persion xiaohong = chcacheTest.findByName("小红");
        log.info("第一次查询"+xiaohong.getAge());
        Persion xiaolv = chcacheTest.findByName("小红");
        log.info("第二次查询"+xiaolv.getAge());
        System.out.println("咋回事，不动了");
    }
}