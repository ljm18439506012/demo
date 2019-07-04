package com.lijm.demo.scheduledtasks;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@Component
@Slf4j
public class ScheDuledTasks {


//    @Scheduled(fixedRate = 5000)
    public void seeTime() {
        log.info("当前时间是："+LocalDateTime.now().toString());
    }
}
