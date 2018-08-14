<%@ page import="com.westos.web01.service.CityService" %>
<%@ page import="com.westos.web01.bean.Shengfen" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/24
  Time: 16:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%

    String name=request.getParameter("name");
    pageContext.setAttribute("name",name);
    CityService cityService=new CityService();
    List<Shengfen> list = cityService.initShengfen();
    pageContext.setAttribute("list",list);
    pageContext.setAttribute("date",new Date());
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:out value="${param.name}" escapeXml="true" />
<c:out value="${name1}" default="hello" />
<c:set var="a" value="你好" scope="page" />
<c:out value="${a}" />
<c:if test="${empty name1}">
    <h1>name1为空</h1>
</c:if>
<c:if test="${not empty name1}">
    <h1>name1不为空</h1>
</c:if>
<c:choose >
    <c:when test="${not empty name}">
        <h1><c:out value="${name}"/> </h1>
    </c:when>

</c:choose>
<c:forEach var="item" items="${list}">
    <h2>${item.name}</h2>
</c:forEach>

<c:forTokens items="1,2,3" delims="," var="item">
    <h2>${item}</h2>
</c:forTokens>
<c:url var="u" value="login.jsp">
    <c:param name="name" value="westos"/>
</c:url>
${u}
<fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss"/>
<fmt:formatNumber value="56" pattern="0000" />
<fmt:formatNumber value='234682.155' type='currency'/>
</body>
</html>
