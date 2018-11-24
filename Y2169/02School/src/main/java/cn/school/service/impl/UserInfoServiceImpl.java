package cn.school.service.impl;/**
 * Created by Happy on 2018-11-06.
 */

import cn.school.dao.IUserInfoDAO;
import cn.school.entity.Dictionary;
import cn.school.entity.UserInfo;
import cn.school.service.IUserInfoService;
import cn.school.utils.MyBatisUtil;

import java.util.List;

/**
 * 作者：微冷的雨
 *
 * @create 2018-11-06
 * 博客地址:www.cnblogs.com/weilengdeyu
 */
public class UserInfoServiceImpl implements IUserInfoService {
    private IUserInfoDAO dao= MyBatisUtil.getSession().getMapper(IUserInfoDAO.class);
    @Override
    public UserInfo isLogin(UserInfo info) throws Exception {
        return dao.isLogin(info);
    }

    @Override
    public List<Dictionary> findAllDictionary() {
        return dao.findAllDictionary();
    }

    @Override
    public List<UserInfo> findUserAll() {
        return dao.findUserAll();
    }

    @Override
    public int SaveBind(Integer cid, Integer tid) {
        return dao.SaveBind(cid,tid);
    }

    @Override
    public Dictionary getDictionaryByUGradeId(Integer ugradeid) {
        return dao.getDictionaryByUGradeId(ugradeid);
    }

    @Override
    public List<UserInfo> getTeacherByDicId(Integer cid) {
        return dao.getTeacherByDicId(cid);
    }
}
