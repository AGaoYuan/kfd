package com.kfd.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 咖啡豆
 * @Date: 2018/12/11 14:00
 * @Description:
 */
@RestController
public class IndexController {


    @RequestMapping("/index")
    public String index(){
        return "index";
    }

}
