package cn.news.service.impl;

import java.util.List;

import cn.news.dao.impl.CategoryDAOImpl;
import cn.news.entity.Category;
import cn.news.service.ICategoryService;

public class CategoryServiceImpl implements ICategoryService{
	//´´½¨dao²ãÊµÀý
	CategoryDAOImpl cdi = new CategoryDAOImpl();

	@Override
	public List<Category> findAlls() throws Exception {
		return cdi.findAlls();
	}

	@Override
	public Category getCate(int id) throws Exception {
		return cdi.getCate(id);
	}

	@Override
	public boolean updateCate(Category category) throws Exception {
		return cdi.updateCate(category);
	}

	@Override
	public boolean delete(String cid) throws Exception {
		return cdi.delete(cid);
	}

	@Override
	public boolean save(Category category) throws Exception {
		return cdi.save(category);
	}

	@Override
	public List<Category> getOnePageData(int pageIndex, int pageSize) throws Exception {
		return cdi.getOnePageData(pageIndex, pageSize);
	}

	@Override
	public int getTotalCate() throws Exception {
		return cdi.getTotalCate();
	}
	
	

}
