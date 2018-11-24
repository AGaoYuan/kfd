package cn.school.web;

import cn.school.entity.Dictionary;
import cn.school.entity.UserInfo;
import cn.school.service.IUserInfoService;
import cn.school.service.impl.UserInfoServiceImpl;
import cn.school.utils.PageUtil;
import com.alibaba.fastjson.JSONObject;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.print.Doc;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Happy on 2018-11-06.
 */

public class UserInfoServlet extends HttpServlet {

    //1.引入service接口
    private IUserInfoService service=new UserInfoServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //进行请求区分
        String action = request.getParameter("action");
        //登录
        if ("login".equals(action)){
            login(request,response);
            //查询所有班级
        }else if ("bindTeacher".equals(action)){
            try {
                bindTeacher(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //查询所有老师
        }else if ("findUserAll".equals(action)){
            try {
                findUserAll(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //班级绑定老师前先把班级id保存到session
        }else if ("SaveDicid".equals(action)){
            String dicid = request.getParameter("dicid");
            request.getSession().setAttribute("Dicid",dicid);
            request.getRequestDispatcher("jsp/person_manage/classteacherbindset.jsp").forward(request,response);
            //绑定老师
        }else if ("SaveBind".equals(action)){
            try {
                SaveBind(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //退出系统
        }else if ("logout".equals(action)){
            request.getSession().removeAttribute("uinfo");
            response.sendRedirect("/jsp/login.jsp");
            //查询该学生所在的班级
        }else if ("findClassCondition".equals(action)){
            try {
                findClasses(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //根据班级id查询该班级所有的老师
        }else if ("findTeacherCondition".equals(action)){
            try {
                getTeacherByDicId(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

/**/
    }

    /**
     * 根据班级id查询该班级所有的老师
     * @param request
     * @param response
     * @throws Exception
     */
    private void getTeacherByDicId(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Integer cid = Integer.parseInt(request.getParameter("cid"));
        List<UserInfo> UList = service.getTeacherByDicId(cid);
        if (UList!=null){
            ResponseJson(UList,response,request);
        }

    }

    /**
     * 查询该学生所在的班级
     * @param request
     * @param response
     * @throws Exception
     */
    private void findClasses(HttpServletRequest request, HttpServletResponse response) throws Exception {
        UserInfo uinfo = (UserInfo) request.getSession().getAttribute("uinfo");
        Dictionary Dic = service.getDictionaryByUGradeId(uinfo.getUgradeid());
        if (Dic!=null&&Dic.getDicname()!=null){
            ResponseJson(Dic,response,request);
        }
    }

    /**
     * 班级绑定老师
     * @param request
     * @param response
     * @throws Exception
     */
    private void SaveBind(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取到班级的id
        Integer cid = Integer.parseInt(request.getParameter("cid"));
        //获取到老师的id
        Integer tid = Integer.parseInt(request.getParameter("tid"));
        //进行添加
        int count = service.SaveBind(cid,tid);
        //判断是否添加成功
        if (count>0){
            response.getWriter().write("y");
        }else{
            response.getWriter().write("n");
        }

    }

    /**
     * 查询所有老师
     * @param request
     * @param response
     * @throws Exception
     */
    private void findUserAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<UserInfo> list = service.findUserAll();
        PageUtil<UserInfo> page = new PageUtil<UserInfo>();
        if (list!=null){
            page.setList(list);
            ResponseJson(page,response,request);
        }
    }

    //响应json对象
    public static void ResponseJson(Object obj,HttpServletResponse response,HttpServletRequest request) throws Exception{
        //异常处理
        request.setCharacterEncoding("utf-8");
        String JsonData = JSONObject.toJSONStringWithDateFormat(obj, "yyyy-mm-dd");
        PrintWriter out = response.getWriter();
        out.write(JsonData);
        out.flush();
        out.close();
    }


    /**
     * 拿到所有班级
     * @param request
     * @param response
     * @throws Exception
     */
    private void bindTeacher(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Dictionary> list= service.findAllDictionary();
        if (list!=null){
            request.getSession().setAttribute("list",list);
            request.getRequestDispatcher("jsp/person_manage/classteacherbind.jsp").forward(request,response);
        }
    }

    /**
     * 验证用户登录
     * @param request
     * @param response
     */
    private void login(HttpServletRequest request, HttpServletResponse response) {
        //自己创建
        UserInfo info=new UserInfo();
        //最普通的请求方式剥离出我们的数据 。
        String uname = request.getParameter("uname");
        String upwd = request.getParameter("upwd");
        info.setUname(uname);
        info.setUpwd(upwd);
        try {
            //2.调度service的方法
            UserInfo login = service.isLogin(info);
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
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request,response);
    }
}
