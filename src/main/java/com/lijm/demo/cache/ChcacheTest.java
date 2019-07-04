package com.lijm.demo.cache;

import com.lijm.demo.jpatest.entity.Persion;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

@CacheConfig(cacheNames = "persions")
public interface ChcacheTest extends JpaRepository<Persion, Integer> {

    @Cacheable
    @Query("from Persion where name = ?1")
    Persion findByName(String name);
}
