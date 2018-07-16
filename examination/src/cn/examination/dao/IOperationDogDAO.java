package cn.examination.dao;

import java.util.List;

import cn.examination.entity.dog;


public interface IOperationDogDAO {

	//添加
	public int saveAll()throws Exception;
	//更新
	public int Update()throws Exception;
	//查询
	public List<dog> findResult()throws Exception;
	
	
}
