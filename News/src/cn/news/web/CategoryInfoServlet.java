package cn.news.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.methods.DeleteMethod;

import cn.news.entity.Category;
import cn.news.entity.NewsInfo;
import cn.news.service.impl.CategoryServiceImpl;
import cn.news.util.PageUtil;
import jdk.nashorn.internal.runtime.RewriteException;

/**
 * Servlet implementation class CategoryInfoServlet
 */
@WebServlet("/CategoryInfoServlet")
public class CategoryInfoServlet extends HttpServlet {
	
	private CategoryServiceImpl cs = new CategoryServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决中文乱码
		request.setCharacterEncoding("utf-8");
		//解决响应后的乱码
		response.setCharacterEncoding("utf-8");
		//获取提交地址的属性
		String action = request.getParameter("action");
		//查询所有新闻类型
		if ("categorylist".equals(action)) {
			//findAll(request,response);
			try {
				userlistOnePage(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		//修改前先查询
		}else if ("UpAll".equals(action)) {
			updateAll(request,response);
		//修改新闻类型
		}else if("updateCate".equals(action)) {
			update(request,response);
		//删除
		}else if("del".equals(action)) {
			delete(request,response);
		//添加新闻类型
		}else if ("saveCate".equals(action)) {
			save(request,response);
		}
		
		
	}
	
	
	private void userlistOnePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//0.1Page对象
		PageUtil<Category> pageUtil = new PageUtil<Category>();
		//0.2属性赋值
		int pageSize=3;
		pageUtil.setPageSize(pageSize);
		//当前第几页
		int pageIndex = 1;
		String i = request.getParameter("curPage");
		if (i!=null&&!i.equals("")) {
			pageIndex=Integer.parseInt(i);
		}
		pageUtil.setPageIndex(pageIndex);
		//总记录数
		int totalUsers = cs.getTotalCate();
		pageUtil.setTotalRecords(totalUsers);
		//总页数
		int totalPages = pageUtil.getTotalRecords()%pageUtil.getPageSize()==0?pageUtil.getTotalRecords()/pageUtil.getPageSize():pageUtil.getTotalRecords()/pageUtil.getPageSize()+1;
		pageUtil.setTotalPages(totalPages);
		//泛型集合
		List<Category> list = cs.getOnePageData(pageUtil.getPageIndex(), pageUtil.getPageSize());
		pageUtil.setList(list);
		//将page对象整体放入request
		request.setAttribute("pageutil", pageUtil);
		try {
			//0.4转发
			request.getRequestDispatcher("/console/categoryManage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	//添加新闻类型
	private void save(HttpServletRequest request, HttpServletResponse response) {
		String catename = request.getParameter("CateName");
		Category category = new Category();
		category.setCatename(catename);
		try {
			boolean flag = cs.save(category);
			if (flag) {
				request.getRequestDispatcher("/CategoryInfoServlet?action=categorylist").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//删除新闻类型
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		String cid = request.getParameter("cateid");
		try {
			boolean flag = cs.delete(cid);
			if (flag) {
				request.getRequestDispatcher("/CategoryInfoServlet?action=categorylist").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//修改新闻类型
	private void update(HttpServletRequest request, HttpServletResponse response) {
		String cateName = request.getParameter("cateName");
		String cateid = request.getParameter("Cateid");
		System.out.println(cateid);
		int cid =Integer.parseInt(cateid);
		Category category = new Category();
		category.setCateid(cid);
		category.setCatename(cateName);
		try {
			boolean flag = cs.updateCate(category);
			if (flag) {
				request.getRequestDispatcher("/CategoryInfoServlet?action=categorylist").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//修改前先查询出指定的新闻类型
	private void updateAll(HttpServletRequest request, HttpServletResponse response) {
		String cid = request.getParameter("cid");
		int id = Integer.parseInt(cid);
		try {
			Category cate = cs.getCate(id);
			request.setAttribute("cate", cate);
			request.getRequestDispatcher("/console/categoryRelease.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//查询所有新闻类型
	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Category> list = cs.findAlls();
			request.setAttribute("catelist", list);
			request.getRequestDispatcher("/console/categoryManage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
