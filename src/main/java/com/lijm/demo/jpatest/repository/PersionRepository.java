package com.lijm.demo.jpatest.repository;

import com.lijm.demo.jpatest.entity.Persion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author Administrator
 */
public interface PersionRepository extends JpaRepository<Persion, Integer> {

    /**
     * 根据姓名查询人类信息
     * @param name
     * @return
     */
    @Query(value = "select * from persion p where p.name = '小红'", nativeQuery = true)
    Persion findPersionByName(String name);

}
