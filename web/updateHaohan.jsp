<%@ page import="com.westos.web01.bean.Haohan" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/28
  Time: 10:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //获取从客户端提交的数据
    String xuhao = request.getParameter("xuhao");
    String xingming = request.getParameter("xingming");
    //获取好汉排行榜,并且注意检查NPE
    List<Haohan> list=(List)application.getAttribute("haohan");
    //2. 处理NPE
    if(list==null){
        list=new ArrayList();
    }
    String msg="输入的好汉序号不存在";
    //3. 查找
    for(Haohan hh:list){
        if(hh.getXuhao().equals(Integer.valueOf(xuhao))){
            //因为序号相同,所以不用再更新序号
            hh.setXingming(xingming);
            msg="好汉资料修改成功";
            break;
        }
    }
%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<script>
    alert("<%=msg%>");
    document.location.href="paihangbang.jsp";
</script>
</body>
</html>
