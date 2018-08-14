<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.westos.web01.bean.Haohan" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/28
  Time: 10:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //1. 获取好汉排行榜
    List<Haohan> list=(List)application.getAttribute("haohan");
    //2. 处理NPE
    if(list==null){
        list=new ArrayList();
    }
    //3.获取接收的参数
    String xuhao = request.getParameter("xuhao");
    //4. 查找
    for(Haohan hh:list){
        //注意数据类型检查,避免类型转换异常
        if(hh.getXuhao().equals(Integer.valueOf(xuhao))){
            //找到了好汉数据
            pageContext.setAttribute("hh",hh);
            break;
        }
    }

%>
<html>
<head>
    <title>修改</title>
</head>
<body>
<form name="form1" action="./updateHaohan.jsp">
    序号:<input type="text" name="xuhao" value="<c:out value="${hh.xuhao}"/>" placeholder="请输入序号"/>
    姓名:<input type="text" name="xingming" value="<c:out value="${hh.xingming}"/>" placeholder="请输入姓名">
    <button type="submit">修改</button>
</form>
</body>
</html>
