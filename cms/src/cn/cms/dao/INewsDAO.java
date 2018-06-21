package cn.cms.dao;

import java.util.List;

import cn.cms.entity.News;

/**
 * 书籍接口
 * @author 21600
 *
 */
public interface INewsDAO {
	/**
	 * 返回书籍方法
	 * @return 返回书籍对象集合
	 */
	List<News> findAllResultSet();
	
	
	
}
