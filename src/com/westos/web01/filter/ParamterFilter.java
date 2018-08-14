package com.westos.web01.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;


public class ParamterFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        Map<String, String[]> map = req.getParameterMap();

        System.out.println(((HttpServletRequest)req).getRequestURL());
        System.out.println(((HttpServletRequest)req).getRequestURI());
        System.out.println(((HttpServletRequest)req).getSession());
        System.out.println(((HttpServletRequest)req).getServletContext());
        System.out.println("filter中的参数输出开始");
        System.out.println(map);
        System.out.println("filter中的参数输出结束");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        //获取web.xml中的配置参数
        String urls=config.getInitParameter("urls");
        System.out.println("filter init");
        System.out.println(urls);
    }

}
