package cn.news.service.impl;

import java.util.List;

import cn.news.dao.impl.UserInfoDAOImpl;
import cn.news.entity.UserInfo;
import cn.news.service.IUserInfoService;

public class UserInfoServiceImpl implements IUserInfoService{
	//创建dao实例
	UserInfoDAOImpl ui =new UserInfoDAOImpl();
	
	//判断用户登录
	@Override
	public UserInfo isLogin(UserInfo Info) throws Exception {
		return ui.isLogin(Info);
	}
	
	//查询所有用户
	@Override
	public List<UserInfo> findAll() throws Exception {
		return ui.findAll();
	}
	
	//删除所选用户
	@Override
	public boolean delete(String uid) throws Exception {
		return ui.delete(uid);
	}
	
	//添加一个用户
	@Override
	public boolean save(UserInfo userInfo) throws Exception {
		return ui.save(userInfo);
	}
	
	//修改用户信息
	@Override
	public boolean update(UserInfo userInfo) throws Exception {
		return ui.update(userInfo);
	}
	
	//修改前先查询出选中的用户
	@Override
	public UserInfo getUser(int id) throws Exception {
		return ui.getUser(id);
	}
	
	//分页显示用户信息
	@Override
	public List<UserInfo> getOnePageData(int pageIndex, int pageSize) throws Exception {
		return ui.getOnePageData(pageIndex, pageSize);
	}
	
	//统计所有用户个数
	@Override
	public int getTotalUsers() throws Exception {
		return ui.getTotalUsers();
	}

	public int getTotalUsersCount(String uname) throws Exception {
		return ui.getTotalUsersCount(uname);
	}

	@Override
	public List<UserInfo> getOnePageDataHasCondition(Integer pageIndex, int pageSize, String uname)throws Exception {
		return ui.getOnePageDataHasCondition(pageIndex,pageSize,uname);
	}

	
	
	

	
	
	
	
}
