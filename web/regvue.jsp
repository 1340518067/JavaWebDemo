<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/28
  Time: 16:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/vue.js"></script>
    <script src="js/jquery.min.js"></script>
</head>
<body>
<div id="app">
    <ul>
        <li v-for="(value,key) in users">{{key}},{{value}}</li>
    </ul>
<form method="post" name="form1" action="doreg.jsp">
    用户名:<input name="username" v-model="username" id="username" type="text" />
    密码:<input name="pwd" id="pwd" v-model="pwd" type="password" />
    <button type="button" id="submitbtn" v-on:click="dosubmit()">提交</button>
</form>
</div>
<script>
    var vue=new Vue({
        el: '#app',
        data:{
            username:'',
            pwd:'',
            users:{},
            inited:true
        },
        methods:{
            dosubmit:function(){
                var data={};
                data.username=this.username;
                data.pwd=this.pwd;
                jQuery.post('doreg.jsp',data,function(result,resp){
                    console.log(result);
                    console.log(resp)
                    if(vue.inited){
                        vue.users=result.users;
                        vue.inited=false;
                        return;
                    }
                    if(result.msg.indexOf("用户名已存在")>=0){
                        alert('用户名已存在');
                    }else{
                        alert('用户注册成功');
                        vue.inited=false;
                        vue.users=result.users;
                    }
                },'json');
            }
        },
        mounted:function(){
            console.log('init');
            this.dosubmit();
        }
    });
</script>
</body>
</html>
