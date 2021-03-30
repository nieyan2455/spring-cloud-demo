package com.ny.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author nieyan
 * @create 2021-02-19 15:32
 **/
@RestController()
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    String port;

    @GetMapping("/get/{id}")
    public String get(@PathVariable("id") Long id) {
        return "nacos registory。serverport" + port + "/t id" + id;
    }

    @GetMapping("/feign/timout")
    public String timout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "end";
    }
}
