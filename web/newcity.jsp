<%@ page import="com.westos.web01.service.CityService" %>
<%@ page import="com.westos.web01.bean.Shengfen" %>
<%@ page import="java.util.List" %>
<%@ page import="org.apache.commons.lang3.StringUtils" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/24
  Time: 14:44
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
   // pageContext.setAttribute("sheng",sheng);
    request.setAttribute("sheng",list.get(0));

%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE-edge">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <title>vue01</title>
</head>
<body>
<h1><%=application.getRealPath("/")%></h1>
<h1><%=sheng%></h1>
<%--以下两行代码等价--%>
<h1><%=request.getAttribute("sheng")%></h1>
<h2>${sheng.name},${sheng.citys[0]}</h2>
<h2>${1+2 lt 5}</h2>
<%--以下两行代码等价--%>
<h2><%=request.getParameter("sheng")%></h2>
<h2>${param.sheng}</h2>
<h2>${requestScope.sheng.name}</h2>
<h2>${empty hello}</h2>

<form name='form1' action='' method='post'>
    省份：
   <select style='color:red' onchange='dochange()' id="sheng" name="sheng">
    <option value="">请选择省份</option>
<%


    Shengfen selectedshengfen=null;
    for(Shengfen sf:list){
        String selected="";
        if(StringUtils.equals(sf.getName(),sheng)){
            selected="selected";
            selectedshengfen=sf;
        }
        %>
       <option value='<%=sf.getName()%>' <%=selected%>><%=sf.getName()%></option>
<%

    }
    %>
       </select>
<%

    if(sheng!=null){
        %>
    城市:
    <select  onchange='dochange()' name='city'>
    <option value=''>请选择城市</option>

<%
        for(String cs:selectedshengfen.getCitys()){
            String selected="";
            if(StringUtils.equalsIgnoreCase(city,cs)){
                selected="selected";
            }
            %>
        <option value='<%=cs%>' <%=selected%>><%=cs%></option>
<%

        }
        %>
        </select>
<%
    }
    %>
    <button type='submit'>提交</button>
    <%

    if(sheng!=null){
    %>
    <h3>您选择的是:<%=sheng%>
    <%

        if(city!=null){

            out.println(city);
        }
        out.println("</h3>");
    }
    %>

        <script>
         function dochange(){
            form1.submit();
         }
        </script>
        </form></body></html>

<%


%>