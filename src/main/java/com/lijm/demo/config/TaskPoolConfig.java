package com.lijm.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
@EnableAsync
public class TaskPoolConfig {

    public Executor taskExecutor() throws Exception {
        // 创建线程池对象
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // 核心线程数10：线程池创建时候初始化的线程数
        executor.setCorePoolSize(10);
        // 最大线程数20：只有缓冲队列满了之后才会申请超过核心线程数的线程
        executor.setMaxPoolSize(20);
        // 缓冲队列：用来缓冲执行任务的队列
        executor.setQueueCapacity(200);
        // 允许线程的空闲时间60秒
        executor.setKeepAliveSeconds(60);
        // 线程池名的前缀
        executor.setThreadNamePrefix("taskExecutor-");
        // ⽤来设置线程池关闭的时候等待所有任务都完成再继续销毁其他的Bean
        // 这样这些异步任务的销毁就会先于Redis线程池的销毁,避免出现线程池销毁，任务未销毁而出现的错误
        executor.setWaitForTasksToCompleteOnShutdown(true);
        // 线程池对拒绝任务的处理策略：这⾥采⽤了	CallerRunsPolicy	策略，当线程池没有处理能⼒的
        //时候，该策略会直接在	execute	⽅法的调⽤线程中运⾏被拒绝的任务；如果执⾏程序已关闭，则
        //会丢弃该任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        return executor;
    }
}
