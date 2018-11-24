package com.kfd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/24 11:21
 * @Description:
 */
@Controller
public class OrderController {

    //首页
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    //查询
    @RequestMapping("/findOrder")
    public String findOrder(){
        return "findOrder";
    }

    //添加
    @RequestMapping("/SaveOrder")
    public String SaveOrder(){
        return "SaveOrder";
    }

    //删除
    @RequestMapping("/deleteOrder")
    public String deleteOrder(){
        return "deleteOrder";
    }

    //修改
    @RequestMapping("/updateOrder")
    public String updateOrder(){
        return "updateOrder";
    }






}
