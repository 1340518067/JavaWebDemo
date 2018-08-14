<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.westos.web01.bean.Haohan" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.westos.web01.service.HaohanService" %>
<%@ page import="com.westos.web01.service.HaohanServiceImpl" %>
<%@ page import="com.westos.web01.service.HaohanServiceInterface" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/28
  Time: 9:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
//    //获取好汉排行榜
//    List<Haohan> list=(List)application.getAttribute("haohan");
//    //处理list的空值,以防止后面出现空指针异常
//    if(list==null){
//        list=new ArrayList();
//
//        application.setAttribute("haohan",list);
//    }
//    if(list.isEmpty()){
//        Haohan haohan=new Haohan();
//        haohan.setXuhao(1);
//        haohan.setXingming("宋江");
//        list.add(haohan);
//    }

    HaohanServiceInterface haohanService=new HaohanServiceImpl();
    List<Haohan> list = haohanService.listHaohan();
    pageContext.setAttribute("haohan",list);




%>
<html>
<head>
    <title>排行榜</title>
</head>
<body>
<h2>使用jsp输出排行榜</h2>
<table border="1">
    <tr>
        <td>
            序号
        </td>
        <td>
            姓名
        </td>
        <td>
            操作
        </td>
    </tr>
    <%
        //1. 使用jsp输出
        for(Haohan hh:list){
            %>
    <tr>
        <td><%=hh.getXuhao()%></td>
        <td><%=hh.getXingming()%></td>
        <td><a href="edit.jsp?xuhao=<%=hh.getXuhao()%>">修改</a>  删除 </td>
    </tr>
    <%
        }
    %>
</table>
<h2>使用jstl输出排行榜</h2>
<table border="1">
    <tr>
        <td>
            序号
        </td>
        <td>
            姓名
        </td>
        <td>
            操作
        </td>
    </tr>
    <%--使用jstl输出--%>
    <c:forEach var="item" items="${haohan}">
        <tr>
            <td><c:out value="${item.xuhao}"/> </td>
            <td><c:out value="${item.xingming}"/> </td>
            <td><a href="edit.jsp?xuhao=<c:out value="${item.xuhao}"/>">修改</a>  删除 </td>
        </tr>
    </c:forEach>
</table>

<form name="form1" action="./saveHaohan">
    序号:<input type="text" name="xuhao" placeholder="请输入序号"/>
    姓名:<input type="text" name="xingming" placeholder="请输入姓名">
    <button type="submit">添加</button>
</form>
</body>
</html>
