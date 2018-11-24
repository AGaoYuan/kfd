package cn.kfd.service;

import cn.kfd.mapper.UserInfoMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/23 10:50
 * @Description:
 */
@Service
@Slf4j
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public int insertUser(String uname,String upwd){
        int result = userInfoMapper.insert(uname, upwd);
        System.out.println("结果："+result);
        return 1;
    }


}
