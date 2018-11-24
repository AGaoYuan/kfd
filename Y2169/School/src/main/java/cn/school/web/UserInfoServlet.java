package cn.school.web;

import cn.school.entity.UserInfo;
import cn.school.service.IUserInfoService;
import cn.school.service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Happy on 2018-11-06.
 */
@WebServlet(name = "/UserInfoServlet")
public class UserInfoServlet extends HttpServlet {

    //1.引入service接口
    private IUserInfoService userInfoService=new UserInfoServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");

        if ("login".equals(action)){
            //login(request,response);
        }else if ("verifyUser".equals(action)){
            String uname = request.getParameter("uname");
            PrintWriter out = response.getWriter();
            if (uname=="微冷的雨"){
                out.print("false");
            }else{
                out.print("true");
            }

        }

    }

    /*private void login(HttpServletRequest request, HttpServletResponse response) {
        //自己创建
        UserInfo info=new UserInfo();
        //最普通的请求方式剥离出我们的数据 。
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        info.setUname(uname);
        info.setUpwd(upwd);
        try {
            //2.调度service的方法
            UserInfo login = userInfoService.isLogin(info);
            //3.根据结果进行转发或者重定向
            if (login!=null&&login.getUname()!=null){
                //登录成功
                //记录session
                request.getSession().setAttribute("uinfo",login);
                //跳转到index.jsp
                request.getRequestDispatcher("/jsp/index.jsp").forward(request,response);
            }else{
                //登录失败
                request.setAttribute("error","用户名或者密码错误");
                //跳转到login.jsp
                request.getRequestDispatcher("/jsp/login.jsp").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
