package com.westos.web01.servlet;

import com.westos.web01.bean.Shengfen;
import com.westos.web01.service.CityService;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;


public class CityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String sheng=request.getParameter("sheng");
        String city=request.getParameter("city");
        CityService cityService=new CityService();
        List<Shengfen> list = cityService.initShengfen();


        response.getWriter().print("<!DOCTYPE html> <html lang=\"zh-CN\"> <head> <meta charset=\"utf-8\"> <meta http-equiv=\"X-UA-Compatible\" content=\"IE-edge\"> <meta name=\"viewport\" content=\"width=device-width,initial-scale=1\"> <title>vue01</title>  </head> <body>");
        response.getWriter().println("<form name='form1' action='' method='post'>");
        response.getWriter().println("省份：");
        response.getWriter().println("<select style='color:red' onchange='dochange()' id=\"sheng\" name=\"sheng\">\n" +
                "  \t<option value=\"\">请选择省份</option>\n");
        Shengfen selectedshengfen=null;
        for(Shengfen sf:list){
            String selected="";
            if(StringUtils.equals(sf.getName(),sheng)){
                selected="selected";
                selectedshengfen=sf;
            }
            response.getWriter().println("<option value='"+sf.getName()+"' "+selected+">"+sf.getName()+"</option>");
        }
        response.getWriter().println("</select>");
        if(sheng!=null){
            response.getWriter().println("城市:");
            response.getWriter().println("<select  onchange='dochange()' name='city'>");
            response.getWriter().println("<option value=''>请选择城市</option>");
            for(String cs:selectedshengfen.getCitys()){
                String selected="";
                if(StringUtils.equalsIgnoreCase(city,cs)){
                    selected="selected";
                }
                response.getWriter().println("<option value='"+cs+"' "+selected+">"+cs+"</option>");
            }
            response.getWriter().println("</select>");
        }
        response.getWriter().println("<button type='submit'>提交</button>");
        if(sheng!=null){
            response.getWriter().println("<h3>您选择的是:"+sheng);
            if(city!=null){
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                response.getWriter().println(city);
            }
            response.getWriter().println("</h3>");
        }

        response.getWriter().println("<script>" +
                "function dochange(){" +
                " form1.submit(); " +
                "}</script>");
        System.out.println("request.getRequestURL="+request.getRequestURL());
        System.out.println("request.getRequestURI="+request.getRequestURI());
        System.out.println("request.getServletPath="+request.getServletPath());
        System.out.println("request.getRemoteAddr="+request.getRemoteAddr());
        response.getWriter().print("</form></body></html>");
    }
}
