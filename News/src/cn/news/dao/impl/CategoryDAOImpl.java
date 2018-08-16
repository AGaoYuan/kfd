package cn.news.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import cn.news.dao.BaseDAO;
import cn.news.dao.ICategoryDAO;
import cn.news.entity.Category;

public class CategoryDAOImpl extends BaseDAO implements ICategoryDAO {

	@Test
	 public void testaddcate() throws Exception {
		/*List<Category> list = findAlls();
		for (Category item : list) {
			System.out.println(item.getCateid()+":"+item.getCatename());
		}*/
		
	 }
	
	//查询所有新闻类型
	@Override
	public List<Category> findAlls() throws Exception {
		List<Category> list = new ArrayList<Category>();
		String sql = "SELECT * FROM category";
		ResultSet rs = this.executeQuery(sql);
		if (rs!=null) {
			while(rs.next()){
				Category cate = new Category();
				cate.setCateid(rs.getInt("cateid"));
				cate.setCatename(rs.getString("catename"));
				list.add(cate);
			}
		}
		return list;
	}

	//按照特定的条件查询
	@Override
	public Category getCate(int id) throws Exception {
		Category cate = new Category();
		String sql = "select * from category where cateid = ?";
		ResultSet rs = this.executeQuery(sql, id);
		if (rs!=null) {
			if (rs.next()) {
				cate.setCateid(rs.getInt("cateid"));
				cate.setCatename(rs.getString("catename"));
			}
			CloseAll();
		}
		return cate;
	}

	//修改新闻类型
	@Override
	public boolean updateCate(Category category) throws Exception {
		boolean flag = false;
		//sql
		String sql = "UPDATE category SET catename=? WHERE cateid = ?";
		Object objs [] = {category.getCatename(),category.getCateid()};
		int count = this.executeUpdate(sql, objs);
		if (count>0) {
			flag = true;
		}
		return flag;
	}

	//删除新闻类型
	@Override
	public boolean delete(String cid) throws Exception {
		boolean flag = false;
		String sql = "delete from category where cateid=?";
		int count = this.executeUpdate(sql, cid);
		if (count>0) {
			flag=true;
		}
		return flag;
	}

	//添加新闻类型
	@Override
	public boolean save(Category category) throws Exception {
		boolean flag = false;
		String sql = "INSERT INTO category(catename) VALUES(?)";
		Object [] objs = {category.getCatename()};
		int count = this.executeUpdate(sql, objs);
		if (count>0) {
			flag=true;
		}
		return flag;
	}

	@Override
	public List<Category> getOnePageData(int pageIndex, int pageSize) throws Exception {
		List<Category> list = new ArrayList<Category>();
		String sql = "select * from category limit ?,?";
		Object objs [] = {(pageIndex-1)*pageSize,pageSize};
		ResultSet rs = this.executeQuery(sql, objs);
		if (rs!=null) {
			while(rs.next()){
				Category cate = new Category();
				cate.setCateid(rs.getInt("cateid"));
				cate.setCatename(rs.getString("catename"));
				list.add(cate);
			}
		}
		return list;
	}

	@Override
	public int getTotalCate() throws Exception {
		int count = 0;
		String sql = "select count(1) as sum from category";
		ResultSet rs = this.executeQuery(sql);
		if (rs!=null) {
			while(rs.next()){
				count = rs.getInt("sum");
			}
		}
		return count;
	}
	
	

}
