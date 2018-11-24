package cn.happy.dao;

import cn.happy.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserInfoMapper {

	//查询用户列表
	public List<UserInfo> getUserList();

	//查询用户总记录数
	public int findTotalUser();

	//查询用户带条件
	public List<UserInfo> getUserCondition(int id);

	//模糊查询
	public List<UserInfo> fuzzFindUser(UserInfo user);

	//智能标签Array
	public List<UserInfo> FindArrayUser(int[] nums);

	//智能标签ForEach
	public List<UserInfo> FindListUser(List<Integer> list);

	//智能标签ForEach List UserInfo
	public List<UserInfo> FindListUserInfo(List<UserInfo> list);

	//添加一个用户
	public int saveUser(UserInfo userInfo);



}
