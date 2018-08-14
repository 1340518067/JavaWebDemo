<%@ page import="java.util.Date" %>
<%@ page import="com.westos.web01.bean.Shengfen" %>


<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
    response.setCharacterEncoding("utf-8");
    request.setCharacterEncoding("utf-8");
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>早上好</h1>
<%--
  这里是jsp的注释
 --%>
<!--这是html的注释-->
<%! String b="apple"; %>
<%
    //int c=1/0;
    String a="hello";
    a=a+" world";
    request.setAttribute("hello",a);
    out.println("今天的日期是:"+new Date());
%>
<%
    if(b.equals("banana")){
%>
<%= a %>
<%}%>
<%@ include file="inc/top.jsp" %>
<%@ include file="login.jsp" %>
<%
    // request.getRequestDispatcher("index.jsp").forward(request,response);
  //  response.sendRedirect("index.jsp");
%>
<%--<jsp:params>--%>
<%--<jsp:param name="westos" value="xian"/>--%>
<%--</jsp:params>--%>
<%--<jsp:forward page="index.jsp" >--%>
    <%--<jsp:param name="name" value="westos" />--%>
<%--</jsp:forward>--%>
<%--<jsp:include page="login.jsp"/>--%>

<%
    Shengfen sx=new Shengfen();
    sx.setName("陕西");
    //pageContext.setAttribute("sx",sx);
    session.setAttribute("sx",sx);
%>
<jsp:useBean id="shanxi" scope="session" class="com.westos.web01.bean.Shengfen">
    <jsp:setProperty name="shanxi" property="name" value="陕西" />
</jsp:useBean>
<%
    String shengfen=request.getParameter("shengfen");
    shanxi.setName(shengfen);

%>
<%--<jsp:setProperty name="shanxi" property="name" param="shengfen" />--%>
<h2><jsp:getProperty name="shanxi" property="name"/></h2>
</body>
</html>
