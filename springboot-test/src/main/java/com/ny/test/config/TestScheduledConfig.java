package com.ny.test.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author nieyan
 * @create 2021-03-24 10:41
 **/
/*@Configuration*/
public class TestScheduledConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(executorService());
    }

    public ExecutorService executorService() {
        return Executors.newScheduledThreadPool(5);
    }
}
