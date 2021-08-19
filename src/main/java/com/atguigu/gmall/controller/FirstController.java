package com.atguigu.gmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//todo @Controller 注解返回的是页面的路径，如果不需要返回 就加此注解
//todo @RestController = @Controller +  @ResponseBody 对类的所有方法定义
//@Controller
@RestController
public class FirstController {
    @RequestMapping("/first")
//    @ResponseBody
    public String test(){
        return "this is first";
    }
}
