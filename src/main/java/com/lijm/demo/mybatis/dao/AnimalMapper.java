package com.lijm.demo.mybatis.dao;

import com.lijm.demo.mybatis.entity.Animal;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AnimalMapper {

    /**
     * 根据姓名查询动物信息
     * @param name
     * @return
     */
    @Select("select * from animal where name=#{name}")
    Animal findByName(String name);

    /**
     * 添加动物
     * @param name
     * @param type
     * @return
     */
    @Insert("insert into animal(name, type) values(#{name},#{type})")
    Integer insert(@Param("name") String name, @Param("type") String type);
}
