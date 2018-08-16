package cn.news.service;

import java.util.List;

import cn.news.entity.Category;

public interface ICategoryService {
	
	//0.1查询新闻列表
	public List<Category> findAlls() throws Exception;
	
	//0.2查询特定新闻
	public Category getCate(int id) throws Exception;
	
	//0.3修改新闻内容
	public boolean updateCate(Category category)throws Exception;
	
	//0.4删除用户
	public boolean delete(String cid)throws Exception;
	
	//0.5添加用户
	public boolean save(Category category)throws Exception;
	
	//定制一个只获取单页数据的方法
	public List<Category> getOnePageData(int pageIndex,int pageSize) throws Exception;
	
	//获取总记录数
	public int getTotalCate() throws Exception;
	
	
	
}
