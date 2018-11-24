package cn.book.controller;

import cn.book.model.Book;
import cn.book.service.IBookService;
import cn.book.service.impl.BookServiceImpl;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/21 16:40
 * @Description:
 */
@WebServlet(name = "BookServlet",urlPatterns = "/BookServlet")
public class BookServlet extends HttpServlet {

    private IBookService service = new BookServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String action = request.getParameter("action");
        if ("showlist".equals(action)){
            try {
                findAll(request,response);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 查询所有图书
     * @param request
     * @param response
     * @throws Exception
     */
    private void findAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
        List<Book> list = null;
        String catename = request.getParameter("catename");
        String bookName = request.getParameter("bookName");
        System.out.println(catename+"++++++++"+bookName);

        if (catename=="请选择分类"||bookName==""){
            list = service.getBookAndCategoryList(null, null);
        }else if (catename=="请选择分类"||bookName!=""){
            list = service.getBookAndCategoryList(bookName, null);
        }else if (catename!=""&&bookName!=""&&catename!="请选择分类"){
            list = service.getBookAndCategoryList(bookName, catename);
        }

        if (list!=null){
            request.setAttribute("list",list);
            ResponseJson(list,response,request);
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
