package cn.kfd.controller;

import cn.kfd.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/23 11:02
 * @Description:
 */
@RestController
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/insertUser")
    @Transactional
    public int insertUser(String uname,String upwd){
        int i = userInfoService.insertUser(uname, upwd);
        int num = 1/0;
        System.out.println(i);
        return i;
    }


}
