package cn.news.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.news.dao.BaseDAO;
import cn.news.dao.IUserInfoDAO;
import cn.news.entity.UserInfo;

public class UserInfoDAOImpl extends BaseDAO implements IUserInfoDAO {

	@Test
	public void testUserinfo() throws Exception{
		UserInfo userInfo = new UserInfo();
		userInfo.setUname("ะกร๗");
		userInfo.setUid(6);
		/*UserInfo login = isLogin(userInfo);
		if (login!=null) {
			System.out.println("success");
		}else{
			System.out.println("No");
		}*/
		/*boolean flag = save(userInfo);
		if (flag) {
			System.out.println("ok");
		}*/
		/*String uname = userInfo.getUname();
		Integer uid = userInfo.getUid();
		boolean flag = update(uid, uname);
		if (flag) {
			System.out.println(uid);
		}*/
	}
	
	@Override
	public UserInfo isLogin(UserInfo Info) throws Exception {
		String sql = "select * from userInfo where uname=? and upwd=?";
		Object [] objs = {Info.getUname(),Info.getUpwd()};
		ResultSet rs = this.executeQuery(sql, objs);
		UserInfo userInfo = null;
		if (rs!=null) {
			if (rs.next()) {
				userInfo = new UserInfo();
				userInfo.setUid(rs.getInt("uid"));
				userInfo.setUname(rs.getString("uname"));
				userInfo.setUpwd(rs.getString("upwd"));
			}
			CloseAll();
		}
		return userInfo;
	}

	@Override
	public List<UserInfo> findAll() throws Exception {
		List<UserInfo> list = new ArrayList<UserInfo>();
		String sql = "select * from userinfo";
		ResultSet rs = executeQuery(sql);
		UserInfo userInfo = null;
		if (rs!=null) {
			while(rs.next()){
				userInfo = new UserInfo();
				userInfo.setUid(rs.getInt("uid"));
				userInfo.setUname(rs.getString("uname"));
				userInfo.setUpwd(rs.getString("upwd"));
				list.add(userInfo);
			}
			CloseAll();
		}
		return list;
	}

	@Override
	public boolean delete(String uid) throws Exception {
		boolean flag = false;
		String sql = "delete from userinfo where uid=?";
		int result = executeUpdate(sql,uid);
		if (result>0) {
			flag=true;
		}
		CloseAll();
		return flag;
		
	}

	@Override
	public boolean save(UserInfo userInfo) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO userinfo(uname,upwd) VALUES(?,?)";
		Object [] objs = {userInfo.getUname(),userInfo.getUpwd()};
		int count = this.executeUpdate(sql, objs);
		if (count>0) {
			flag=true;
		}
		CloseAll();
		return flag;
	}

	public boolean update(UserInfo userInfo) throws Exception {
		boolean flag = false;
		String sql = "UPDATE userinfo SET uname=?,upwd=? WHERE uid = ?";
		int count = this.executeUpdate(sql, userInfo.getUname(),userInfo.getUpwd(),userInfo.getUid());
		if (count>0) {
			flag = true;
		}
		CloseAll();
		return flag;
	}

	@Override
	public UserInfo getUser(int id) throws Exception {
		UserInfo user = new UserInfo();
		String sql = "select * from userinfo where uid = ?";
		ResultSet rs = this.executeQuery(sql, id);
		if (rs!=null) {
			if (rs.next()) {
				user.setUid(rs.getInt("uid"));
				user.setUname(rs.getString("uname"));
				user.setUpwd(rs.getString("upwd"));
			}
			CloseAll();
		}
		return user;
	}

	@Override
	public List<UserInfo> getOnePageData(int pageIndex,int pageSize) throws Exception {
		List<UserInfo> list = new ArrayList<UserInfo>();
		String sql = "select * from userinfo limit ?,?";
		Object objs [] = {(pageIndex-1)*pageSize,pageSize};
		ResultSet rs = this.executeQuery(sql, objs);
		while(rs.next()){
			UserInfo info = new UserInfo();
			info.setUid(rs.getInt("uid"));
			info.setUname(rs.getString("uname"));
			info.setUpwd(rs.getString("upwd"));
			list.add(info);
		}
		CloseAll();
		return list;
	}

	@Override
	public int getTotalUsers() throws Exception {
		int count = 0;
		String sql = "select count(1) as sum from userinfo";
		ResultSet rs = this.executeQuery(sql);
		if (rs!=null) {
			while(rs.next()){
				count = rs.getInt("sum");
			}
		}
		CloseAll();
		return count;
	}

	@Override
	public int getTotalUsersCount(String uname) throws Exception {
		int count = 0;
		String sql = "select count(1) as sum from userinfo where uname like ?";
		ResultSet rs = this.executeQuery(sql, "%"+uname+"%");
		if (rs!=null) {
			if(rs.next()){
				count = rs.getInt("sum");
			}
		}
		return count;
	}

	@Override
	public List<UserInfo> getOnePageDataHasCondition(Integer pageIndex, int pageSize, String uname)throws Exception {
		List<UserInfo> list = new ArrayList<UserInfo>();
		String sql = "select * from userinfo where uname like ? limit ?,?";
		Object objs [] = {"%"+uname+"%",(pageIndex-1)*pageSize,pageSize};
		ResultSet rs = this.executeQuery(sql, objs);
		if (rs!=null) {
			while(rs.next()){
				UserInfo info = new UserInfo();
				info.setUid(rs.getInt("uid"));
				info.setUname(rs.getString("uname"));
				info.setUpwd(rs.getString("upwd"));
				list.add(info);
			}
			CloseAll();
		}
		return list;
	}

	
	
	
	
}
