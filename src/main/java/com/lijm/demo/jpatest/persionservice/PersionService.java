package com.lijm.demo.jpatest.persionservice;

import com.lijm.demo.jpatest.entity.Persion;

public interface PersionService {

    Persion findByName(String name);
}
