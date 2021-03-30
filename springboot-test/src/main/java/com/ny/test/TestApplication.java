package com.ny.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author nieyan
 * @create 2021-03-23 17:12
 **/
@SpringBootApplication
@EnableScheduling
@EnableAsync
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class);
    }
}
