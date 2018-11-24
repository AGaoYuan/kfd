package cn.kfd.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/21 10:11
 * @Description:
 */
@Service
@Slf4j
public class MemberService {

    @Async
    //思路，使用AOP技术在运行时创建一个单独的线程进行执行
    public String SaveMemberAndEmail(){
        System.out.println("2");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("3");
        return "kfd";
    }

}
