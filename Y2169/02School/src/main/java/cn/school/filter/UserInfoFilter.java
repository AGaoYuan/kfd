package cn.school.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: 咖啡豆
 * @Date: 2018/11/14 10:12
 * @Description:
 */
@WebFilter(filterName = "UserInfoFilter")
public class UserInfoFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request =(HttpServletRequest)req;
        HttpServletResponse response =(HttpServletResponse)resp;

        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
