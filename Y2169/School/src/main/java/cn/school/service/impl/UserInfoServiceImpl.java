package cn.school.service.impl;/**
 * Created by Happy on 2018-11-06.
 */

import cn.school.dao.IUserInfoDAO;
import cn.school.entity.UserInfo;
import cn.school.service.IUserInfoService;
import cn.school.utils.MyBatisUtil;

/**
 * 作者：微冷的雨
 *
 * @create 2018-11-06
 * 博客地址:www.cnblogs.com/weilengdeyu
 */
public class UserInfoServiceImpl implements IUserInfoService {
    private IUserInfoDAO userInfoDAO= MyBatisUtil.getSqlSession().getMapper(IUserInfoDAO.class);
    @Override
    public UserInfo isLogin(UserInfo info) throws Exception {
        return userInfoDAO.isLogin(info);
    }
}
