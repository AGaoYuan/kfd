package com.kfd.service;

import com.kfd.mapper.UserInfoMapper;
import com.kfd.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/23 12:15
 * @Description:
 */
@Service
public class UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public UserInfo findByName(String uname){
        UserInfo user = userInfoMapper.findByName(uname);
        return user;
    }


}
