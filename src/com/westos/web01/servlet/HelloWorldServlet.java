package com.westos.web01.servlet;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


public class HelloWorldServlet extends HttpServlet {

    @Override
    public void destroy() {
        System.out.println("servlet被销毁");
        super.destroy();
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("servlet初始化");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        //获取客户端提交的验证码
        String yzm=request.getParameter("yzm");
        //获取服务器端的验证码
        String rndstr=(String)request.getSession().getAttribute("rndstr");
        //常规比较字符串
        //yzm.equals(rndstr);
        //比较验证码是否一致
        //修改验证码和输入均为null时验证码认证通过的bug
        //TODO:验证码失效问题
        // 每次使用后均失效,以防止暴力破解
        request.getSession().removeAttribute("rndstr");
        if(yzm!=null&&rndstr!=null&&StringUtils.equalsIgnoreCase(yzm,rndstr)){
            response.getWriter().println("<h1>验证码认证通过</h1>");
        }else{
            response.getWriter().println("<h1>验证码认证失败</h1>");
            return;
        }
        //验证用户和密码是否正确
        request.getSession().setAttribute("username",request.getParameter("username"));
        //response.getWriter().print("<!DOCTYPE html> <html lang=\"zh-CN\"> <head> <meta charset=\"utf-8\"> <meta http-equiv=\"X-UA-Compatible\" content=\"IE-edge\"> <meta name=\"viewport\" content=\"width=device-width,initial-scale=1\"> <title>vue01</title>  </head> <body>");
        response.getWriter().println("<h1>"+getServletContext().getAttribute("ctxname")+"</h1>");
        response.getWriter().print("<h1>getServletName="+getServletName()+"</h1>");
        response.getWriter().print("<h1>getServletInfo="+getServletInfo()+"</h1>");
        response.getWriter().print("<h1>charset="+getInitParameter("charset")+"</h1>");
        Enumeration<String> names = getInitParameterNames();
        while (names.hasMoreElements()){
            response.getWriter().println("<h1>"+names.nextElement()+"</h1>");
        }
        System.out.println(getServletContext());
        response.getWriter().println("您的用户名是:"+request.getParameter("username"));
        response.getWriter().println("request.getMethod()="+request.getMethod());
        response.getWriter().println("request.getContextPath()="+request.getContextPath());
        response.getWriter().println("<h1>选择的城市是:"+request.getParameter("city")+"</h1>");
        response.getWriter().println("<h1>选择的性别是:"+request.getParameter("xingbie")+"</h1>");
        response.getWriter().println("<h1>喜欢的水果是:"+request.getParameter("shuiguo")+"</h1>");
        response.getWriter().println("<h1>喜欢的水果是:"+ StringUtils.join(request.getParameterValues("shuiguo"),",")+"</h1>");
        response.getWriter().println("<h1>喜欢的颜色是:<span style='color:"+request.getParameter("yanse")+"'>"+ request.getParameter("yanse")+"</span></h1>");
        Enumeration<String> reqheaders = request.getHeaderNames();
//        request.getServletPath();
//        request.getRequestURI();
//        request.getRequestURL();
        while (reqheaders.hasMoreElements()){
            String header=reqheaders.nextElement();
            response.getWriter().println("<h1>"+header+"="+request.getHeader(header)+"</h1>");
        }
        //response.getWriter().print("</body></html>");

    }
}
