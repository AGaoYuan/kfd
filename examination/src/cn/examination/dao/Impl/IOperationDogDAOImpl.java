package cn.examination.dao.Impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.examination.dao.BaseDAO;
import cn.examination.dao.IOperationDogDAO;
import cn.examination.entity.dog;

public class IOperationDogDAOImpl extends BaseDAO implements IOperationDogDAO{

	@Override
	public int saveAll() throws Exception {
		dog dog = new dog();
		String sql = "insert into dog(`Name`,health,love,strain) "
				+ "value("+dog.getName()+","+dog.getHealth()+","+dog.getLove()+","+dog.getStrain()+")";
		int count = this.executeUpdate(sql);
		
		
		return count;
	}

	@Override
	public int Update()throws Exception {
		dog dog = new dog();
		String sql = "";
		int count = this.executeUpdate(sql);
		
		
		return count;
	}

	@Override
	public List<dog> findResult()throws Exception {
		List<dog>list=new ArrayList<dog>();
		String sql="select * from dog";
		ResultSet rs=this.executeQuery(sql);
		if(rs!=null){
			while(rs.next()){
				dog dogs=new dog();
				dogs.setId(rs.getInt("id"));
				dogs.setName(rs.getString("Name"));
				dogs.setHealth(rs.getInt("health"));
				dogs.setLove(rs.getInt("love"));
				dogs.setStrain(rs.getString("strain"));
				list.add(dogs);
			}
		}
		return list;
	}
	
	
	
}
