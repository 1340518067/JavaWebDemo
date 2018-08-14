<%@ page import="java.io.File" %>
<%@ page import="org.apache.commons.io.IOUtils" %>
<%@ page import="java.io.FileInputStream" %>
<%@ page import="java.io.OutputStream" %>
<%@ page import="java.net.URLEncoder" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/31
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //读取一个文件
    File file=new File("e:\\div.png");
   //重置输出流,非必须
    // response.reset();
    OutputStream os = response.getOutputStream();
    //指定下载的文件名,并对中文文件进行编码以防止乱码
    response.setHeader("Content-disposition","filename="+ URLEncoder.encode("中文.png","utf-8"));
    //写文件到输出流
    IOUtils.copy(new FileInputStream(file),os);
    //写到输出流
    os.flush();
    //关闭
    os.close();
%>