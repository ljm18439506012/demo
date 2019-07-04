package com.lijm.demo.jpatest.persionservice.impl;

import com.lijm.demo.jpatest.entity.Persion;
import com.lijm.demo.jpatest.persionservice.PersionService;
import com.lijm.demo.jpatest.repository.PersionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PersionServiceImpl implements PersionService {

    @Autowired
    PersionRepository persionRepository;

    @Override
    public Persion findByName(String name) {
        log.info("在service中给我小红的信息");
        return persionRepository.findPersionByName(name);
    }
}
