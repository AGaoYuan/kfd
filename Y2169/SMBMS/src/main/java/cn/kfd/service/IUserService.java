package cn.kfd.service;

import cn.kfd.model.SmbmsUser;

import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/1 9:45
 * @Description:
 */
public interface IUserService {

    //验证登录
    public SmbmsUser getUser(SmbmsUser user);

    //查询所有用户加分页
    public List<SmbmsUser> findAllUser();

    //按照条件查询
    public SmbmsUser updateFindUser(String uid);

    //修改用户信息
    public int updateUser(SmbmsUser user);

    public int SaveUser(SmbmsUser smbmsUser);

    //删除用户
    public int deleteUser(Integer id);

    public List<SmbmsUser> findLikeUser(String uname);
}
