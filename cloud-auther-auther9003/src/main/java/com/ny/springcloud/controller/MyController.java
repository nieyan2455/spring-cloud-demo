package com.ny.springcloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author nieyan
 * @create 2021-03-11 11:18
 **/
@Controller
public class MyController {

    @PostMapping("/my-forward")
    public String forward(){
        return "forward:/login-success";
    }

    @GetMapping("/login-success")
    @ResponseBody
    public String loginSuccess(){
        return "登陆成功";
    }
}
