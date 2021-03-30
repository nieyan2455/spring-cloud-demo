package com.ny.test.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author nieyan
 * @create 2021-03-24 9:47
 **/
@Slf4j
@Component
public class TestScheduling {

    @Scheduled(fixedRate = 2000)
    public void test1() {
        log.info(Thread.currentThread().getName() + "=====test1=====");
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Scheduled(fixedRate = 2000)
    public void test2() {
        log.info(Thread.currentThread().getName() + "=====test2=====");
    }
}
