package com.lijm.demo.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.Future;

@Component
@Slf4j
public class Task {

    public static Random random = new Random();

    @Async("taskExecutor")
    public Future<String > doTaskOne() throws Exception {
        log.info("开始做任务一");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        log.info("完成任务一，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务一完成");
    }

    @Async("taskExecutor")
    public	Future<String >	doTaskTwo()	throws	Exception	{
        System.out.println("开始做任务⼆");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务⼆，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务二完成");
    }

    @Async("taskExecutor")
    public Future<String > doTaskThree() throws Exception {
        System.out.println("开始做任务三");
        long start = System.currentTimeMillis();
        Thread.sleep(random.nextInt(10000));
        long end = System.currentTimeMillis();
        System.out.println("完成任务三，耗时：" + (end - start) + "毫秒");
        return new AsyncResult<>("任务三完成");
    }

    @Async("taskExecutor")
    public Future<String> run() throws Exception {
        long sleep = random.nextInt(10000);
        log.info("开始执行任务，需要耗时：" + sleep + "毫秒");
        Thread.sleep(sleep);
        return new AsyncResult<>("test");
    }
}
