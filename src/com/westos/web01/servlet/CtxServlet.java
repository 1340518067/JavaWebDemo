package com.westos.web01.servlet;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.RandomUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class CtxServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        //获取Servletcontext
        ServletContext ctx = getServletContext();
        ctx=request.getServletContext();

        ctx.setAttribute("ctxname","westos");
        //获取计数器的值
        Integer counter=(Integer) ctx.getAttribute("counter");
        if(counter==null){
            counter=1;
        }else{
            counter=counter+1;
        }
        ctx.setAttribute("counter",counter);

        response.getWriter().println("<h1>您是第"+counter+"位访问本站的用户.</h1>");
        response.getWriter().println("<h1>您的IP地址是:"+request.getRemoteAddr()+"</h1>");




    }
}
