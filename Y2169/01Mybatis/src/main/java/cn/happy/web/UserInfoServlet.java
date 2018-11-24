package cn.happy.web;

import cn.happy.entity.UserInfo;
import cn.happy.service.IUserInfoService;
import cn.happy.service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserInfoServlet extends HttpServlet {

    private IUserInfoService is = new UserInfoServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<UserInfo> list = is.getUserList();
        request.setAttribute("list",list);
        request.getRequestDispatcher("/index.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}
