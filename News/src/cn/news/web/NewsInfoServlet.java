package cn.news.web;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.news.entity.NewsInfo;
import cn.news.service.impl.NewsInfoServiceImpl;
import cn.news.util.PageUtil;

/**
 * Servlet implementation class NewsInfoServlet
 */
@WebServlet("/NewsInfoServlet")
public class NewsInfoServlet extends HttpServlet {
	
	//创建Service层实例
	private NewsInfoServiceImpl ns = new NewsInfoServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决乱码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取标识属性
		String action = request.getParameter("action");
		
		//查询全部记录
		if ("newslist".equals(action)) {
			//findAll(request, response);
			try {
				userlistOnePage(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		//修改前先查询出用户选定的记录
		}else if ("UpAll".equals(action)) {
			specificQuery(request, response);
		//修改新闻
		}else if("updateNews".equals(action)) {
			updateSpecific(request, response);
		//删除新闻记录
		}else if("del".equals(action)) {
			Delete(request, response);
		//添加一条新闻加文件上传
		}else if ("saveNews".equals(action)) {
			Save(request, response);
			
		}
		
		
		
		
    }
	
	

	private void userlistOnePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//0.1Page对象
		PageUtil<NewsInfo> pageUtil = new PageUtil<NewsInfo>();
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
		int totalUsers = ns.getTotalNews();
		pageUtil.setTotalRecords(totalUsers);
		//总页数
		int totalPages = pageUtil.getTotalRecords()%pageUtil.getPageSize()==0?pageUtil.getTotalRecords()/pageUtil.getPageSize():pageUtil.getTotalRecords()/pageUtil.getPageSize()+1;
		pageUtil.setTotalPages(totalPages);
		//泛型集合
		List<NewsInfo> list = ns.getOnePageData(pageUtil.getPageIndex(), pageUtil.getPageSize());
		pageUtil.setList(list);
		//将page对象整体放入request
		request.setAttribute("pageutil", pageUtil);
		try {
			//0.4转发
			request.getRequestDispatcher("/console/newsManage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	//查询全部新闻
	/*private void findAll(HttpServletRequest request, HttpServletResponse response){
		NewsInfo newsInfo = new NewsInfo();
		try {
			List<NewsInfo> list = ns.findAll(newsInfo);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/console/newsManage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	//查询特定新闻
	private void specificQuery(HttpServletRequest request, HttpServletResponse response){
		String nid = request.getParameter("nid");
		int id = Integer.parseInt(nid);
		try {
			NewsInfo news = ns.getNews(id);
			request.setAttribute("news", news);
			request.getRequestDispatcher("/console/newsRelease.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//修改新闻内容
	private void updateSpecific(HttpServletRequest request, HttpServletResponse response){
		String newstitle = request.getParameter("Newstitle");
		String newssummary = request.getParameter("Newssummary");
		String newscontent = request.getParameter("Newscontent");
		String uid = request.getParameter("newsid");
		System.out.println(uid);
		int newsid =Integer.parseInt(uid);
		NewsInfo newsInfo = new NewsInfo();
		newsInfo.setNewstitle(newstitle);
		newsInfo.setNewssummary(newssummary);
		newsInfo.setNewscontent(newscontent);
		newsInfo.setNewsdate(new Date());
		newsInfo.setNewsid(newsid);
		try {
			boolean flag = ns.updateNews(newsInfo);
			if (flag) {
				request.getRequestDispatcher("/NewsInfoServlet?action=newslist").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//删除新闻内容
	private void Delete(HttpServletRequest request, HttpServletResponse response){
		String uid = request.getParameter("newsid");
		try {
			boolean flag = ns.delete(uid);
			if (flag) {
				request.getRequestDispatcher("/NewsInfoServlet?action=newslist").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//添加新闻内容
	private void Save(HttpServletRequest request, HttpServletResponse response){
		//创建新闻对象
		NewsInfo newsInfo = new NewsInfo();
		try {
			//创建文件上传需要的工厂对象（factory）
			DiskFileItemFactory factory = new DiskFileItemFactory();
			//创建ServletFileUpload
			ServletFileUpload sfu = new ServletFileUpload(factory);
			//判断表单提交元素是否为文件类型
			boolean flag = ServletFileUpload.isMultipartContent(request);
			if (flag) {//返回true证明文件上传请求
				//获取表单中元素的集合，每一项的类型都为FileItem
				List<FileItem> list = sfu.parseRequest(request);
				//使用Iterator循环遍历
				Iterator<FileItem> items = list.iterator();
				while(items.hasNext()){
					//获取到一项
					FileItem item = items.next();
					if (item.isFormField()) {//判断是否为普通字段
						String fileName = item.getFieldName();
						if ("Newstitles".equals(fileName)) {
							//文件上传是可能会出现乱码，使用getString("utf-8")的方式解决乱码，不能使用getString()
							newsInfo.setNewstitle(item.getString("utf-8"));
						}else if ("Newssummarys".equals(fileName)) {
							newsInfo.setNewssummary(item.getString("utf-8"));
						}else if ("Newscontents".equals(fileName)) {
							newsInfo.setNewscontent(item.getString("utf-8"));
						}
						//获取当前日期
						newsInfo.setNewsdate(new Date());
					}else{//返回false证明为文件元素
						//首先获取服务器所在的位置,并在服务器地址下面指定一个新的文件夹
						String uploadPath=request.getSession().
							getServletContext().
							getRealPath("upLoadFiles/");
						System.out.println(uploadPath);
						//通过File类创建文件夹
						File file = new File(uploadPath);
						if (!file.exists()) {//判断文件夹是否存在，不存在则创建
							file.mkdirs();
						}
						//获取上传的名称
						String fileName = item.getName();
						//判断用户是否需要上传文件
						if (!fileName.equals("")&&fileName!=null) {
							//获取上传文件
							File uploadFile = new File(fileName);
							//拼接路径   把获取到的服务器全路径下添加上传的文件
							File saveFile = new File(uploadPath,uploadFile.getName());
							//上传操作
							item.write(saveFile);
							//赋值给对象中的属性
							newsInfo.setNewspic(uploadFile.getName());
						}
					}
				}
			//循环结束后执行添加操作
			boolean isSave = ns.save(newsInfo);
			//判断是否添加成功，添加成功后转发到新闻信息页面
			if (isSave) {
				request.getRequestDispatcher("/NewsInfoServlet?action=newslist").forward(request, response);
			}
		//如果不是文件上传则打印
		}else{
			System.out.println("不是文件上传！");
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

}
