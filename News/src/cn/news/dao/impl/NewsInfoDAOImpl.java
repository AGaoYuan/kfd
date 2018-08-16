package cn.news.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.news.dao.BaseDAO;
import cn.news.dao.INewsInfoDAO;
import cn.news.entity.NewsInfo;

public class NewsInfoDAOImpl extends BaseDAO implements INewsInfoDAO {

	//单测
	@Test
	public void testAll() throws Exception{
		NewsInfo newsInfo = new NewsInfo();
		newsInfo.setNewstitle("大数据");
		newsInfo.setNewssummary("大数据--Newssummary");
		newsInfo.setNewscontent("大数据--Newscontent");
		newsInfo.setNewsdate(new Date());
		newsInfo.setNewsid(1);
		/*try {
			List<NewsInfo> list = findAll(newsInfo);
			for (NewsInfo item : list) {
				System.out.println(item.getNewstitle());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		boolean flag = updateNews(newsInfo);
		if (flag) {
			System.out.println(flag);
		}
		
	}
	
	//查询所有新闻的方法
	@Override
	public List<NewsInfo> findAll(NewsInfo newsInfo) throws Exception {
		List<NewsInfo> list = new ArrayList<NewsInfo>();
		String sql = "SELECT * FROM newsinfo";
		ResultSet rs = this.executeQuery(sql);
		if (rs!=null) {
			while(rs.next()){
				NewsInfo news = new NewsInfo();
				news.setNewsid(rs.getInt("newsid"));
				news.setNewsowner(rs.getString("newsowner"));
				news.setNewstitle(rs.getString("newstitle"));
				news.setNewscontent(rs.getString("newscontent"));
				news.setNewsdate(rs.getDate("newsdate"));
				news.setNewssummary(rs.getString("newssummary"));
				news.setNewscate(rs.getInt("newscate"));
				list.add(news);
			}
			this.CloseAll();
		}
		return list;
	}

	//修改时先查询出该条信息
	@Override
	public NewsInfo getNews(int id) throws Exception {
		NewsInfo newsInfo = new NewsInfo();
		String sql = "select * from newsinfo where newsid = ?";
		ResultSet rs = this.executeQuery(sql, id);
		if (rs!=null) {
			if (rs.next()) {
				newsInfo.setNewsid(rs.getInt("newsid"));
				newsInfo.setNewstitle(rs.getString("newstitle"));
				newsInfo.setNewscontent(rs.getString("newscontent"));
				newsInfo.setNewssummary(rs.getString("newssummary"));
			}
			CloseAll();
		}
		return newsInfo;
	}

	//修改新闻内容
	@Override
	public boolean updateNews(NewsInfo newsInfo) throws Exception {
		boolean flag = false;
		//sql
		String sql = "UPDATE newsinfo SET newstitle=?,newssummary=?,newscontent=?,newsdate=? WHERE newsid = ?";
		Object objs [] = {newsInfo.getNewstitle(),newsInfo.getNewssummary(),newsInfo.getNewscontent(),
				newsInfo.getNewsdate(),newsInfo.getNewsid()};
		int count = this.executeUpdate(sql, objs);
		if (count>0) {
			flag = true;
		}
		return flag;
	}

	//删除新闻方法
	@Override
	public boolean delete(String nid) throws Exception {
		boolean flag = false;
		String sql = "delete from newsinfo where newsid=?";
		int count = this.executeUpdate(sql, nid);
		if (count>0) {
			flag=true;
		}
		return flag;
	}

	//添加新闻方法
	@Override
	public boolean save(NewsInfo newsInfo) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO newsinfo(newstitle,newssummary,newscontent,newsdate,newspic) VALUES(?,?,?,?,?)";
		Object [] objs = {newsInfo.getNewstitle(),newsInfo.getNewssummary(),newsInfo.getNewscontent(),
				newsInfo.getNewsdate(),newsInfo.getNewspic()};
		int count = this.executeUpdate(sql, objs);
		if (count>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public List<NewsInfo> getOnePageData(int pageIndex, int pageSize) throws Exception {
		List<NewsInfo> list = new ArrayList<NewsInfo>();
		String sql = "select * from newsinfo limit ?,?";
		Object objs [] = {(pageIndex-1)*pageSize,pageSize};
		ResultSet rs = this.executeQuery(sql, objs);
		if (rs!=null) {
			while(rs.next()){
				NewsInfo news = new NewsInfo();
				news.setNewsid(rs.getInt("newsid"));
				news.setNewsowner(rs.getString("newsowner"));
				news.setNewstitle(rs.getString("newstitle"));
				news.setNewscontent(rs.getString("newscontent"));
				news.setNewsdate(rs.getDate("newsdate"));
				news.setNewssummary(rs.getString("newssummary"));
				news.setNewscate(rs.getInt("newscate"));
				list.add(news);
			}
		}
		return list;
	}

	@Override
	public int getTotalNews() throws Exception {
		int count = 0;
		String sql = "select count(1) as sum from newsinfo";
		ResultSet rs = this.executeQuery(sql);
		if (rs!=null) {
			while(rs.next()){
				count = rs.getInt("sum");
			}
		}
		return count;
	}

	
	
	
	
}
