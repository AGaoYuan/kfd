package cn.news.service;

import java.util.List;

import cn.news.entity.NewsInfo;
import cn.news.entity.UserInfo;

public interface INewsInfoService {
	
	//查询所有新闻的方法
	public List<NewsInfo> findAll(NewsInfo newsInfo) throws Exception;
	
	//0.2查询特定新闻
	public NewsInfo getNews(int id) throws Exception;
	
	//0.3修改新闻内容
	public boolean updateNews(NewsInfo newsInfo)throws Exception;
	
	//0.4删除用户
	public boolean delete(String uid)throws Exception;
	
	//0.5添加用户
	public boolean save(NewsInfo userInfo)throws Exception;
	
	//定制一个只获取单页数据的方法
	public List<NewsInfo> getOnePageData(int pageIndex,int pageSize) throws Exception;
	
	//获取总记录数
	public int getTotalNews() throws Exception;
	
	
}
