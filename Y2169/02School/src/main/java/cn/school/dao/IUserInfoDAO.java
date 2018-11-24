package cn.school.dao;

import cn.school.entity.Dictionary;
import cn.school.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Happy on 2018-11-06.
 * 用户接口
 */
public interface IUserInfoDAO {
  //01.用于登录的方法 ，入参是一个用户实体  返回值是一个用户实体
    public UserInfo isLogin(UserInfo info) throws Exception;

    //查询
    public List<Dictionary> findAllDictionary();

    //查询所有用户
    public List<UserInfo> findUserAll();

    //班级绑定老师
    public int SaveBind(@Param("cid") Integer cid,@Param("tid") Integer tid);

    //根据学生的班级编号查询该班级
    public Dictionary getDictionaryByUGradeId(Integer ugradeid);

    //根据班级编号查询该班级的老师
    public List<UserInfo> getTeacherByDicId(Integer cid);
}
