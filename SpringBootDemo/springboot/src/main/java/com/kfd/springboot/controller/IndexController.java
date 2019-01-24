package com.kfd.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 咖啡豆
 * @Date: 2019/1/24 13:11
 * @Description:
 */
@RestController
public class IndexController {

    @RequestMapping("/getRedis")
    public String getRedis(String key,String value){

        return "success";
    }

}
