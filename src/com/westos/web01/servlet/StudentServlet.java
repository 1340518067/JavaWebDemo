package com.westos.web01.servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.westos.web01.bean.Student;
import com.westos.web01.service.StudentService;
import com.westos.web01.service.StudentServiceImpl;
import org.apache.commons.io.IOUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("学生操作相关");
        //获取提交的信息（使用json方式）
        String str = IOUtils.toString(request.getInputStream(), "utf-8");
        Student student = JSON.parseObject(str, Student.class);
        //调用服务
        StudentService studentService=new StudentServiceImpl();
        studentService.addStudent(student);
        JSONObject json=new JSONObject();
        json.put("msg","注册成功");
        response.getWriter().print(json.toJSONString());
    }
}
