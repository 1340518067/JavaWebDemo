package com.westos.web01.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Collection;


public class ResponseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        //response.getWriter().println("<h1>输出内容</h1>");
        Collection<String> headers = response.getHeaderNames();
        for(String h:headers){
            System.out.println(h+"="+response.getHeader(h));
        }
        //读取一个文件
        response.setContentType("image/png");
        //response.setContentType("application/msword");

        String filename=request.getParameter("filename");
        File file=new File(filename);
        InputStream in=new FileInputStream(file);
        OutputStream os=response.getOutputStream();
        IOUtils.copy(in,os);

        in.close();
        os.flush();
        os.close();
        //response.sendRedirect(request.getContextPath()+"/city");

    }
}
