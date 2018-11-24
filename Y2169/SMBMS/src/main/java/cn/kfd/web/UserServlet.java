package cn.kfd.web;

import cn.kfd.model.SmbmsUser;
import cn.kfd.service.IUserService;
import cn.kfd.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/2 8:33
 * @Description:
 */
public class UserServlet extends HttpServlet {

    private IUserService service = new UserServiceImpl();

    private HttpSession session = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        session = request.getSession();
        //解决中文乱码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //获取用户操作的对象
        String action = request.getParameter("action");
        if ("login".equals(action)){
            try {
                login(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if ("logout".equals(action)){
            session.removeAttribute("list");
            session.removeAttribute("USER");
            session.removeAttribute("user");
            response.sendRedirect("/pages/login.jsp");
        }else if ("user".equals(action)){
            try {
                findAllUser(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if ("updatefinduser".equals(action)){
            try {
                updateFindUser(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if ("update".equals(action)){
            try {
                UpdateUser(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if ("SaveUser".equals(action)){
            try {
                SaveUser(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if ("deleteUser".equals(action)){
            deleteUser(request,response);
        }else if ("findUser".equals(action)){
            try {
                findUser(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



    }

    private void findUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String uid = request.getParameter("uid");
        SmbmsUser user = service.updateFindUser(uid);
        Date tempbirthday = user.getBirthday();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = format.format(tempbirthday);
        String tempuserRole = user.getUserRole().toString();
        String userRole = "";
        switch (tempuserRole){
            case "1":
                userRole="系统管理员";
                break;
            case "2":
                userRole="经理";
                break;
            case "3":
                userRole="普通员工";
                break;
        }
        if (user!=null){
            request.setAttribute("SmbmsUser",user);
            request.setAttribute("newbirthday",birthday);
            request.setAttribute("userRole",userRole);
            request.getRequestDispatcher("/pages/userView.jsp").forward(request,response);
        }

    }

    /**
     * 删除指定用户
     * @param request
     * @param response
     */
    private void deleteUser(HttpServletRequest request, HttpServletResponse response) {
        String id = (String)request.getParameter("id");
        try {
            int count= service.deleteUser(Integer.valueOf(id));
            if (count>0){
                request.getRequestDispatcher("/UserServlet?action=user").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 添加一名用户
     * @param request
     * @param response
     * @throws Exception
     */
    private void SaveUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userId = request.getParameter("userId");
        String userName = request.getParameter("userName");
        String userpassword = request.getParameter("userpassword");
        String sex = request.getParameter("sex");
        String data =  request.getParameter("data");
        String userphone = request.getParameter("userphone");
        String userAddress = request.getParameter("userAddress");
        String userlei = request.getParameter("userlei");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date a = null;
        a = format.parse(data);
        System.out.println(a);
        SmbmsUser smbmsUser=new SmbmsUser();
        smbmsUser.setUserCode(userId);
        smbmsUser.setUserName(userName);
        smbmsUser.setUserPassword(userpassword);
        smbmsUser.setGender(Integer.valueOf(sex));
        smbmsUser.setBirthday(a);
        smbmsUser.setPhone(userphone);
        smbmsUser.setAddress(userAddress);
        smbmsUser.setUserRole(Long.valueOf(userlei));
        try {
            int count = service.SaveUser(smbmsUser);
            if (count>0){
                request.getRequestDispatcher("/UserServlet?action=user").forward(request,response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 修改用户信息
     * @param request
     * @param response
     * @throws Exception
     */
    private void UpdateUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String userName = request.getParameter("userName");
        String tempgender = request.getParameter("gender");
        String tempdata = request.getParameter("data");
        String userphone = request.getParameter("userphone");
        String userAddress = request.getParameter("userAddress");
        String tempuserRole = request.getParameter("userRole");
        Long uid = Long.parseLong(request.getParameter("Uid"));

        Integer gender = Integer.parseInt(tempgender);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date a = null;
        a = format.parse(tempdata);
        Long userRole = Long.parseLong(tempuserRole);
        System.out.println(uid);

        SmbmsUser user = new SmbmsUser();
        user.setId(uid);
        user.setUserName(userName);
        user.setGender(gender);
        user.setBirthday(a);
        user.setPhone(userphone);
        user.setAddress(userAddress);
        user.setUserRole(userRole);
        int count = service.updateUser(user);
        if (count>0){
            request.getRequestDispatcher("/UserServlet?action=user").forward(request,response);
        }

    }

    /**
     * 修改前查询该用户信息
     * @param request
     * @param response
     * @throws Exception
     */
    private void updateFindUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String uid = request.getParameter("uid");
        SmbmsUser user = service.updateFindUser(uid);
        Date tempbirthday = user.getBirthday();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String birthday = format.format(tempbirthday);
        if (user!=null){
            request.setAttribute("USER",user);
            request.setAttribute("birthday",birthday);
            request.getRequestDispatcher("/pages/userUpdate.jsp").forward(request,response);
        }
    }

    /**
     * 查询所有用户
     * @param request
     * @param response
     * @throws Exception
     */
    private void findAllUser(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String uname = request.getParameter("uname");
        List<SmbmsUser> list = null;
        if (uname!=null){
            list = service.findLikeUser(uname);
        }else{
            list = service.findAllUser();
        }
        if (list!=null){
            request.setAttribute("list",list);
            request.setAttribute("Uname",uname);
            request.getRequestDispatcher("pages/userList.jsp").forward(request,response);
        }
    }

    /**
     * 用户登录
     * @param request
     * @param response
     * @throws Exception
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        SmbmsUser user = new SmbmsUser();
        user.setUserCode(username);
        user.setUserPassword(password);
        SmbmsUser u = service.getUser(user);
        if (u!=null && u.getUserName()!=null){
            session.setAttribute("user",u);
            request.getRequestDispatcher("/pages/welcome.jsp").forward(request,response);
        }else{
            response.sendRedirect("/pages/login.jsp");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        doPost(request,response);
    }
}
