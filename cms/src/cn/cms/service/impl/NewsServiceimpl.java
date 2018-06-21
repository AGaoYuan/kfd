package cn.cms.service.impl;

import java.util.List;

import cn.cms.dao.INewsDAO;
import cn.cms.dao.impl.NewsDAOImpl;
import cn.cms.entity.News;
import cn.cms.service.INewsService;

public class NewsServiceimpl implements INewsService{

	//创建DAO层实现类的对象
	INewsDAO ID = new NewsDAOImpl();
	
	@Override
	public List<News> findAll() {
		//返回DAO层中的结果集方法
		return ID.findAllResultSet();
	}

	
	
	
	
}
