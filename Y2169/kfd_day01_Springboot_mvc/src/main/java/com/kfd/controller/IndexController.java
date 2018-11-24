package com.kfd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/7 13:06
 * @Description:
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/index",produces = "text/html;charset=UTF-8")
    public String index(){
        return "纯手写SpringBoot！！！OK";
    }

}
