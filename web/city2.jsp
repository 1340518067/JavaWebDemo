<%@ page import="com.westos.web01.service.CityService" %>
<%@ page import="com.westos.web01.bean.Shengfen" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/24
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    response.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");
    request.setCharacterEncoding("utf-8");
    String sheng=request.getParameter("sheng");
    String city=request.getParameter("city");
    CityService cityService=new CityService();
    List<Shengfen> list = cityService.initShengfen();
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE-edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>city</title>

</head>
<body>
<form method="post" name="form1" action="">
省份:<select name="sheng">
    <option>请选择省份</option>
    <%
        for(Shengfen sf:list){
            %>
    <option value="<%=sf.getName()%>"><%=sf.getName()%></option>
    <%
        }
    %>
</select>
<select name="city">
    <option>请选择城市</option>
</select>
    <button type="submit">提交</button>
</form>

</body>
</html>
