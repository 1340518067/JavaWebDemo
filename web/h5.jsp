<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/31
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.min.js"></script>
    <script>
        //原生方式实现
        function upload(){
            //构造文件上传对象FormData
            var data=new FormData(document.getElementById("form1"));

            //构造ajax对象,该对象在不同版本浏览器中的名称有所不同
            //本段代码以chrome浏览器为基础演示
            var ajax=new XMLHttpRequest();
            //设置请求参数
            ajax.open("POST","doupload.jsp",true);
            //设置回调函数
            ajax.onload=function(result){
                console.log(result);
                console.log(ajax);
                document.getElementById("resp").innerHTML=ajax.responseText;
            }
            //发送请求
            ajax.send(data);

        }

            //使用jquery上传
            function jqueryupload(){
                //构造fora
                var data1=new FormData(jQuery("#form1")[0]);
                jQuery.ajax({
                    type:'POST',
                    url:'doupload.jsp',
                    data:data1,
                    processData:false,
                    contentType:false,
                    success:function(resp){
                        console.log(resp);
                        jQuery("#resp").html(resp);
                    }
                });
        }
    </script>
</head>
<body>

<form method="post" action="doupload.jsp" id="form1" enctype="multipart/form-data">
    <input type="file" name="file1" id="file1"/>
    <button type="button" onclick="upload()" >原生文件上传</button>
    <button type="button" onclick="jqueryupload()" >jQuery文件上传</button>
</form>
<div id="resp">

</div>
</body>
</html>
