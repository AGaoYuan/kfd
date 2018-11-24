package cn.happy.service.impl;

import cn.happy.dao.UserInfoMapper;
import cn.happy.entity.UserInfo;
import cn.happy.service.IUserInfoService;
import cn.happy.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserInfoServiceImpl implements IUserInfoService {

    //定义session对象
    private SqlSession session;
    //定义dao层接口
    private UserInfoMapper dao;
    //打开会话对象，dao层接口做初始化
    public UserInfoServiceImpl(){
        session = MyBatisUtil.getSqlSession();
        dao = session.getMapper(UserInfoMapper.class);
    }

    //查询用户列表
    @Override
    public List<UserInfo> getUserList() {
        return dao.getUserList();
    }

    //查询用户总记录数
    @Override
    public int findTotalUser() {
        return dao.findTotalUser();
    }

    //查询用户带条件
    @Override
    public List<UserInfo> getUserCondition(int id) {
        return dao.getUserCondition(id);
    }


}
