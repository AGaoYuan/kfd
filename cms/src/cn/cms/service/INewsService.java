package cn.cms.service;

import java.util.List;

import cn.cms.entity.News;

public interface INewsService {

	/**
	 * 获取图书集合方法
	 * @return
	 */
	List<News> findAll();
	
	
}
