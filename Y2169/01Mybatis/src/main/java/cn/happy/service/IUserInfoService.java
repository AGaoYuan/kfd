package cn.happy.service;

import cn.happy.entity.UserInfo;

import java.util.List;

public interface IUserInfoService {

    //查询用户列表
    public List<UserInfo> getUserList();

    //查询用户总记录数
    public int findTotalUser();

    //查询用户带条件
    public List<UserInfo> getUserCondition(int id);


}
