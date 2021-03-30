package com.ny.springcloud.controller;


import com.ny.springcloud.entities.CommonResult;
import com.ny.springcloud.entities.Payment;
import com.ny.springcloud.entities.TOrder;
import com.ny.springcloud.service.IOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import com.ny.springcloud.feign.PaymentFeignService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author nieyan
 * @create 2021-02-19 16:17
 **/
@RestController
@Slf4j
public class OrderController {

    @Value("${nacos.config}")
    private String nacosConfig;

    @Autowired
    private IOrderService orderService;

    private final String uploadpath = "/data/pic";
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public Payment getPayment(@PathVariable("id") Long id) {
        return paymentFeignService.get(id);
    }


    @GetMapping("/consumer/config")
    public String getNacosConfig() {
        log.info("thread==" + Thread.currentThread().getName() + "||nacosConfig" + nacosConfig);
        return nacosConfig;
    }

    @RequestMapping(value = "/consumer/upload", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Object upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "上传文件不能为空";
        }

        try {
            String fileName = null;
            String bizPath = "files";
            String nowday = new SimpleDateFormat("yyyyMMdd").format(new Date());
            File f = new File(uploadpath + File.separator + bizPath + File.separator + nowday);
            if (!f.exists()) {
                f.mkdirs();// 创建文件根目录
            }
            String originalFilename = file.getOriginalFilename();// 获取文件名
            String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
//            fileName = originalFilename.substring(0, originalFilename.lastIndexOf(".")) + "_"
//                    + System.currentTimeMillis() + suffix;
            fileName = UUID.randomUUID().toString().replaceAll("-", "");
            String savePath = f.getPath() + File.separator + fileName + suffix;
            File savefile = new File(savePath);
            FileCopyUtils.copy(file.getBytes(), savefile);
            String dbpath = bizPath + File.separator + nowday + File.separator + fileName + suffix;
            if (dbpath.contains("\\")) {
                dbpath = dbpath.replace("\\", "/");
            }
            return dbpath;
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @PostMapping("/order/create")
    public CommonResult createOrder(@RequestBody TOrder order) {
        CommonResult checkResult = orderService.checkOrder(order);
        if (!checkResult.isSuccess()) {
            return checkResult;
        }
        return orderService.createOrder(order);
    }
}
