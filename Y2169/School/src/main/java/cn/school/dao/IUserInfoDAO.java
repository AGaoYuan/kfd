package cn.school.dao;

import cn.school.entity.UserInfo;

/**
 * Created by Happy on 2018-11-06.
 * 用户接口
 */
public interface IUserInfoDAO {
  //01.用于登录的方法 ，入参是一个用户实体  返回值是一个用户实体
    public UserInfo isLogin(UserInfo info) throws Exception;
}
