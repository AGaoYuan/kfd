package com.kfd.mapper;

import com.kfd.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/23 12:10
 * @Description:
 */
@Repository
public interface UserInfoMapper {

    //查询
    @Select("select * from Userinfo where uname=#{uname}")
    UserInfo findByName(@Param("uname") String uname);

    //添加
    @Insert("INSERT INTO userinfo(uname,upwd) VALUES(#{uname},#{upwd})")
    int SaveUser(@Param("uname") String uname,@Param("upwd") String upwd);

}
