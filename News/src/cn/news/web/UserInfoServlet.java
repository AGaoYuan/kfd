package cn.news.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.news.entity.UserInfo;
import cn.news.service.IUserInfoService;
import cn.news.service.impl.UserInfoServiceImpl;
import cn.news.util.CreateExecl;
import cn.news.util.Message;
import cn.news.util.PageUtil;
import cn.news.util.VerifyCodeUtils;

@WebServlet("/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {
	//实例化UserInfoService对象
	private IUserInfoService uis = new UserInfoServiceImpl();
	
	//创建随机生成验证的实例
	private VerifyCodeUtils vcu = new VerifyCodeUtils();
	
	private AuthImage ai = new AuthImage();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//解决Post请求的中文乱码问题
		request.setCharacterEncoding("utf-8");
		//解决响应回来的编码格式
		response.setCharacterEncoding("utf-8");
		
		String action = request.getParameter("action");
		//判断是否为注销页面
		if ("logout".equals(action)) {
			//清除session
			request.getSession().getAttribute("uname");
			//跳转到login
			response.sendRedirect("/News/console/login.jsp");
		//判断是否为登陆页面
		}else if ("login".equals(action)) {
			//登录
			try {
				loginTwo(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		//判断是否为添加用户页面
		}else if("add".equals(action)){
			//添加
			save(request,response);
			
		//判断是否为查看用户列表
		}else if ("list".equals(action)) {
			//查询所有用户
			//findAll(request,response);
			//分页显示用户
			try {
				userlistOnePage(request,response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		//判断是否为删除页面
		}else if ("del".equals(action)) {
			delete(request,response);
		//判断是否为查询特定记录
		}else if ("modify".equals(action)) {
			//往作用域里放入可以区分出是否为修改操作的值
			request.setAttribute("oper", "Update");
			modify(request,response);
		//判断是否为修改
		}else if ("Update".equals(action)) {
			update(request, response);
		//JNDI测试
		}else if ("JNDI".equals(action)) {
			try {
				Context ctx = new InitialContext();
				String name = (String) ctx.lookup("java:comp/env/tjndi");
				System.out.println(name);
			} catch (NamingException e) {
				e.printStackTrace();
			}
		}else if ("oper".equals(action)) {
			//往作用域里放入可以区分出是否为添加操作的值
			request.setAttribute("oper", "add");
			request.getRequestDispatcher("/console/userAddForm.jsp").forward(request, response);
		//导出报表
		}else if ("export".equals(action)) {
			 /*Message book1 = new Message();
		        book1.setVin("0001");
		        book1.setMessagetime("2016-01-08");
		        book1.setReceivetime("2016-05-06");
		        book1.setMessagetype("车辆登入");
		        book1.setMessagelength("123");
		        book1.setMessage("{115v23v}");
		        List<Message> list = new ArrayList<Message>();
		        list.add(book1);
		        CreateExecl.createExecl(list);*/
			List<UserInfo> user;
			try {
				user = uis.findAll();
				for (UserInfo item : user) {
					Message book1 = new Message();
					book1.setVin(item.getUid().toString());
					book1.setMessagetime("2018-08-12");
					book1.setReceivetime("2018-12-12");
					book1.setMessagetype(item.getUname());
					book1.setMessagelength("123");
					book1.setMessage(item.getUpwd());
					List<Message> list = new ArrayList<Message>();
					list.add(book1);
					CreateExecl.createExecl(list);
				}
				response.sendRedirect("/News/UserInfoServlet?action=list");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
	}
	
	
	private void loginTwo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		UserInfo uInfo = new UserInfo();
		uInfo.setUname(uname);
		uInfo.setUpwd(upwd);
		try {
			UserInfo result = uis.isLogin(uInfo);
			//判断UserInfo对象是否为空
			if (result!=null) {
				session = request.getSession();
				session.setAttribute("uname", uname);
				response.sendRedirect("/News/console/main.jsp");
			}else {
				response.sendRedirect("/News/console/login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	//修改用户信息
	private void update(HttpServletRequest request, HttpServletResponse response) {
		int UID = Integer.parseInt(request.getParameter("uid"));
		String userName = request.getParameter("userName");
		String userpwd = request.getParameter("userPwd");
		UserInfo userInfo = new UserInfo();
		userInfo.setUid(UID);
		userInfo.setUname(userName);
		userInfo.setUpwd(userpwd);
		try {
			boolean flag = uis.update(userInfo);
			if (flag) {
				response.sendRedirect("/News/UserInfoServlet?action=list");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//修改前查询特定信息
	private void modify(HttpServletRequest request, HttpServletResponse response) {
		int uid = Integer.parseInt(request.getParameter("uid"));
		try {
			UserInfo user = uis.getUser(uid);
			request.setAttribute("item", user);
			request.getRequestDispatcher("/console/userAddForm.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//删除用户信息
	private void delete(HttpServletRequest request, HttpServletResponse response) {
		String uid = request.getParameter("id");
		try {
			boolean flag = uis.delete(uid);
			if (flag) {
				response.sendRedirect("/News/UserInfoServlet?action=list");
			}else{
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//查询所有用户
	private void findAll(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<UserInfo> list = uis.findAll();
			if (list!=null) {
				request.setAttribute("list",list);
				request.getRequestDispatcher("/console/userManage.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//添加用户信息
	private void save(HttpServletRequest request, HttpServletResponse response) {
		UserInfo uinfo = new UserInfo();
		String username = request.getParameter("userName");
		String userpwd = request.getParameter("userPwd");
		uinfo.setUname(username);
		uinfo.setUpwd(userpwd);
		try {
			boolean flag = uis.save(uinfo);
			if (flag) {
				request.setAttribute("msg", "添加成功！");
				request.getRequestDispatcher("/UserInfoServlet?action=list").forward(request, response);
			}else{
				request.getRequestDispatcher("/News/console/userAddForm.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//验证登录
	private void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String uname = request.getParameter("uname");
		String upwd = request.getParameter("upwd");
		String VerifyCode = request.getParameter("VerifyCode");
		String vercode = (String) session.getAttribute("verCode");
		System.out.println(VerifyCode);
		System.out.println(vercode);
		if (!VerifyCode.equals(vercode)) {
			request.setAttribute("error", "验证码错误！");
			String err = (String) request.getAttribute("verify");
			System.out.println(err);
			request.getRequestDispatcher("/console/login.jsp").forward(request, response);
			
		}else{
			UserInfo uInfo = new UserInfo();
			uInfo.setUname(uname);
			uInfo.setUpwd(upwd);
			try {
				UserInfo result = uis.isLogin(uInfo);
				//判断UserInfo对象是否为空
				if (result!=null) {
					session = request.getSession();
					session.setAttribute("uname", uname);
					response.sendRedirect("/News/console/main.jsp");
				}else {
					response.sendRedirect("/News/console/login.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	//分页显示用户信息                                        构建分页信息的雏形
	private void userlistOnePage(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String uname = request.getParameter("Uname");
		//0.1Page对象
		PageUtil<UserInfo> pageUtil = new PageUtil<UserInfo>();
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
		
		int totalUserCount = 0;
		if (uname!=null&&!uname.equals("")) {
			totalUserCount = uis.getTotalUsersCount(uname);
		}else{
			//总记录数
			totalUserCount = uis.getTotalUsers();
		}
		pageUtil.setTotalRecords(totalUserCount);
		
		//总页数
		int totalPages = pageUtil.getTotalRecords()%pageUtil.getPageSize()==0?pageUtil.getTotalRecords()/pageUtil.getPageSize():pageUtil.getTotalRecords()/pageUtil.getPageSize()+1;
		pageUtil.setTotalPages(totalPages);
		//***************************
		List<UserInfo> list = null;
		if (uname!=null&&!uname.equals("")) {
			list = uis.getOnePageDataHasCondition(pageUtil.getPageIndex(), pageUtil.getPageSize(),uname);
		}else{
			//泛型集合
			list = uis.getOnePageData(pageUtil.getPageIndex(), pageUtil.getPageSize());
		}
		pageUtil.setList(list);
		if (uname!=null&&!uname.equals("")) {
			request.setAttribute("UserName", uname);
		}
		//将page对象整体放入request
		request.setAttribute("pageutil", pageUtil);
		try {
			String msg = (String) request.getAttribute("msg");
			request.setAttribute("MSG", msg);
			//0.4转发
			request.getRequestDispatcher("/console/userManage.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
