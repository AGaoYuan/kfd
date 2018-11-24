package com.kfd.controller;

import com.kfd.model.UserInfo;
import com.kfd.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @Author: 咖啡豆
 * @Date: 2018/11/23 12:19
 * @Description:
 */
@Controller
public class UserInfoController {

    @Autowired
    private UserInfoService service;

    @RequestMapping("/findByName")
    public UserInfo findByName(String uname){
        UserInfo userInfo = service.findByName(uname);
        return userInfo;
    }

}
