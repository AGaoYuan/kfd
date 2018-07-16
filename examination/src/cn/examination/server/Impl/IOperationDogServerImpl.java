package cn.examination.server.Impl;

import java.util.List;

import cn.examination.dao.Impl.IOperationDogDAOImpl;
import cn.examination.entity.dog;
import cn.examination.server.IOperationDogServer;

public class IOperationDogServerImpl implements IOperationDogServer{

	IOperationDogDAOImpl iddi = new IOperationDogDAOImpl();
	
	@Override
	public int saveAll() throws Exception {
		return iddi.saveAll();
	}

	@Override
	public int Update() throws Exception {
		return iddi.Update();
	}

	@Override
	public List<dog> findResult() throws Exception {
		return iddi.findResult();
	}

	
	
	
}
