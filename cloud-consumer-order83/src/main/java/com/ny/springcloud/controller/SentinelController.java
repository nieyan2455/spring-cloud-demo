package com.ny.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * Sentinel测试类
 *
 * @author nieyan
 * @create 2021-03-15 14:00
 **/
@RestController("/test")
@Slf4j
public class SentinelController {

    /**
     * rt
     * @return
     */
    @GetMapping("testA")
    public String testA(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("testA RT");
        return "this is testA";
    }

    /**
     * 异常比例
     * @return
     */
    @GetMapping("testB")
    public String testB(){
        int a = 10/0;
        log.info("testB===异常比例");
        return "this is testB";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "dealHotKey")
    public String testHotKey(String p1,String p2){
        return "testHotKey";
    }

    public String dealHotKey(String p1, String p2, BlockException blockException){
        return "testHotKey is error, p1 ="+ p1 + " p2=" + p2;
    }
}
