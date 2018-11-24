package cn.kfd.controller;

import cn.kfd.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/21 10:14
 * @Description:
 */
@RestController
@Slf4j
public class SMemberController {

    @Autowired
    private MemberService service;

    @RequestMapping("/SaveMemberAndEmail")
    public String SaveMemberAndEmail() throws Exception {
        System.out.println("1");
        String result = service.SaveMemberAndEmail();
        Thread.sleep(500);
        System.out.println("4");
        return result;
    }

}
