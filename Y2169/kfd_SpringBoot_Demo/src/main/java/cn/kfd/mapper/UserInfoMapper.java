package cn.kfd.mapper;

import cn.kfd.model.UserInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/23 9:22
 * @Description:
 *
 * Repository 代表dao
 * Service 代表service
 * Controller 代表web层
 */
@Repository
public interface UserInfoMapper {

    //查询
    @Select("select * from Userinfo where uname=#{uname}")
    UserInfo findByName(@Param("uname") String uname);

    //添加
    @Insert("INSERT INTO userinfo(uname,upwd) VALUES(#{uname},#{upwd})")
    int insert(@Param("uname") String uname,@Param("upwd") String upwd);

}
