package com.westos.web01.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");

        //获取session
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        //设置session的值
        session.setAttribute("test","test1");
        //获取session中的值
        session.getAttribute("test");
        //删除session中的值
        session.removeAttribute("test");
        //获取session的id
        session.getId();
        //使当前session失效
        session.invalidate();
        //是否新session
        session.isNew();

        response.getWriter().println("<h1>"+session.getAttribute("rndstr")+"</h1>");
    }
}
