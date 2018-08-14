<%@ page import="com.alibaba.fastjson.JSONObject" %>
<%@ page import="com.alibaba.fastjson.JSONArray" %>
<%@ page import="com.alibaba.fastjson.JSON" %>
<%@ page import="com.westos.web01.bean.Shengfen" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/28
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
        //json对象的处理
    JSONObject jsonObject=new JSONObject();
    jsonObject.put("name","陕西");
    JSONArray cities = new JSONArray();
    cities.add("西安");
    cities.add("咸阳");
    jsonObject.put("citys",cities);
    String str="{\"name\":\"陕西\",\"citys\":[\"西安\",\"咸阳\"]}\n";
    JSONObject json = JSON.parseObject(str);
    System.out.println(json.toJSONString());
    Shengfen ashengfen=JSON.parseObject(str, Shengfen.class);
    System.out.println(ashengfen.getName());
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=jsonObject.toJSONString()%>
</body>
</html>
