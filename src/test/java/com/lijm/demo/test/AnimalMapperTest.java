package com.lijm.demo.test;

import com.lijm.demo.mybatis.dao.AnimalMapper;
import com.lijm.demo.mybatis.entity.Animal;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Slf4j
public class AnimalMapperTest {

    @Autowired
    public AnimalMapper animalMapper;

    @Test
    public void testFind() {
        Animal name = animalMapper.findByName("托尼");
        log.info(name.getType());
        Integer insert = animalMapper.insert("加菲", "肥猫");
        log.info(insert.toString());
    }
}