<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/21
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
      <meta charset="UTF-8"/>
    <title>$Title$</title>
  </head>
  <body>
  <%
    Date d=new Date();
    out.write(""+d);
    out.print(d);
  %>
  <h3>汉字</h3>
  <a href="download.jsp">下载</a>
 <%=request.getAttribute("hello")%>
 <%=request.getAttribute("name")%>
 <%=request.getParameter("name")%>
  </body>
</html>
