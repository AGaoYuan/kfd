package cn.news.service;

import java.util.List;

import cn.news.entity.UserInfo;

public interface IUserInfoService {
	
	//01.验证用户登录的方法
	public UserInfo isLogin(UserInfo Info) throws Exception;
	
	//0.2查询用户列表
	public List<UserInfo> findAll() throws Exception;
	
	//0.2查询特定新闻
	public UserInfo getUser(int id) throws Exception;
	
	//0.3删除用户
	public boolean delete(String uid)throws Exception;
	
	//0.4添加用户
	public boolean save(UserInfo userInfo)throws Exception;
	
	//0.5修改用户名
	public boolean update(UserInfo userInfo) throws Exception;
	
	//定制一个只获取单页数据的方法
	public List<UserInfo> getOnePageData(int pageIndex,int pageSize) throws Exception;
	
	//获取总记录数
	public int getTotalUsers() throws Exception;
	
	public int getTotalUsersCount(String uname)throws Exception;

	public List<UserInfo> getOnePageDataHasCondition(Integer pageIndex, int pageSize, String uname)throws Exception;
	
	
}
