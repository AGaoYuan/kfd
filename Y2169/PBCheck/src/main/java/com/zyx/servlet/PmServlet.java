package com.zyx.servlet;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyx.entity.Problem;
import com.zyx.service.IProblemService;
import com.zyx.service.ProblemServiceImpl;
import com.zyx.util.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "PmServlet",urlPatterns = {"/checks"})
public class PmServlet extends HttpServlet {

    private IProblemService service = new ProblemServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决乱码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");

        if (action.equals("showlist")){
            //调度分页查询全部的数据
            showList(request,response);
        }else if (action.equals("add")){
            String title = request.getParameter("title");
            String type = request.getParameter("type");
            String con = request.getParameter("con");
            int classid= Integer.valueOf(type);
            Problem pro = new Problem();
            pro.setTitle(title);
            pro.setClassid(classid);
            pro.setContent(con);
            pro.setCreatedate("2018-07-02");
            try {
                int count = service.addpro(pro);
                if (count>0){
                    request.getRequestDispatcher("/index.jsp").forward(request,response);
                }
                else {
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * 分页查询全部的数据
     * @param request
     * @param response
     */
    private void showList(HttpServletRequest request, HttpServletResponse response) {
        String tvalue = request.getParameter("tvalue");
        //接收页码号
        Integer pageindex = Integer.parseInt(request.getParameter("PageIndex"));
        PageUtil<Problem> page = new PageUtil<Problem>();
        //创建Problem对象
        Problem problem = new Problem();
        if (tvalue!=null){
            problem.setTitle(tvalue);
        }else{
            problem.setTitle(null);
        }


        try {
            //使用PageHelper进行分页
            Page<Problem> objects = PageHelper.startPage(pageindex,2);
            /*PageInfo<Problem> problemPageInfo = objects.toPageInfo();
            List<Problem> list1 = problemPageInfo.getList();*/
            //调度查询全部数据的方法
            List<Problem> list = service.listShow(problem);
            //全部数据的总记录数
            Integer count = service.getTotalRecordsCount(problem);
            page.setTotalRecords(count);
            page.setList(list);
            //转换为JSON对象
            ResponseJson(page,response,request);
            //request.getRequestDispatcher("/index.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //响应json对象
    public static void ResponseJson(Object obj,HttpServletResponse response,HttpServletRequest request) throws Exception{
        //设置编码
        //response.setCharacterEncoding("GBK");
        //异常处理
        String JsonData = JSONObject.toJSONStringWithDateFormat(obj, "yyyy-mm-dd");
        PrintWriter out = response.getWriter();
        out.write(JsonData);
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
