package cn.kfd.service.impl;

import cn.kfd.dao.IUserDAO;
import cn.kfd.model.SmbmsUser;
import cn.kfd.service.IUserService;
import cn.kfd.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/1 9:46
 * @Description:
 */
public class UserServiceImpl implements IUserService {

    private SqlSession sqlSession = null;
    private IUserDAO dao = null;
    public UserServiceImpl(){
        sqlSession = MyBatisUtil.getSqlSession();
        dao = sqlSession.getMapper(IUserDAO.class);
    }

    @Override
    public SmbmsUser getUser(SmbmsUser user) {
        return dao.getUser(user);
    }

    @Override
    public List<SmbmsUser> findAllUser() {
        return dao.findAllUser();
    }

    @Override
    public SmbmsUser updateFindUser(String uid) {
        return dao.updateFindUser(uid);
    }

    @Override
    public int updateUser(SmbmsUser user) {
        return dao.updateUser(user);
    }

    @Override
    public int SaveUser(SmbmsUser smbmsUser) {
        return dao.SaveUser(smbmsUser);
    }

    @Override
    public int deleteUser(Integer id) {
        return dao.deleteUser(id);
    }

    @Override
    public List<SmbmsUser> findLikeUser(String uname) {
        return dao.findLikeUser(uname);
    }


}
