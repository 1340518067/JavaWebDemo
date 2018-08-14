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
    <script src="js/axios.min.js"></script>

</head>
<body>
<div id="app">
    <ul>
        <li v-for="(value,key) in users">{{key}},{{value}}</li>
    </ul>
    <form method="post" name="form1" action="doreg.jsp">
        用户名:<input name="username" v-model="username" id="username" type="text" />
        密码:<input name="pwd" id="pwd" v-model="pwd" type="password" />
        <button type="button" id="submitbtn" v-on:click="dopost()">提交</button>
    </form>
</div>
<script>
    function reguser(param){
        return axios.post("doreg.jsp",param);
    }
    var vue=new Vue({
        el: '#app',
        data: {
            username: '',
            pwd: '',
            users: {},
            inited: true
        },
        methods: {
            dosubmit: function () {
                var data = {};
                data.username = this.username;
                data.pwd = this.pwd;
                var url='doreg.jsp?username='+data.username+'&pwd='+data.pwd;
                axios.get(url).then(function(result){
                    console.log(result);
                    if(vue.inited){
                        vue.users=result.data.users;
                        vue.inited=false;
                        return;
                    }
                    if(result.data.msg.indexOf('用户名已存在')>=0){
                        alert('注册失败');
                    }else{
                        alert('注册成功');
                        vue.inited=false;
                        vue.users=result.data.users;
                    }
                }).catch(function(err){
                    //发生错误时调用
                    console.log(err);
                });
            },
            dopost:function(){
                var data = {};
                data.username = this.username;
                data.pwd = this.pwd;
                var url='doreg.jsp';
                //使用键值对提交参数
                //键值对的格式:useranem=zhangsan&pwd=123456
                var paras=new URLSearchParams();
                paras.append("username",this.username);
                paras.append("pwd",this.pwd);
                paras.append("users",this.users);
                axios.post(url,paras).then(function(result){
                    console.log(result);
                    if(vue.inited){
                        vue.inited=false;
                        vue.users=result.data.users;
                        return;
                    }
                    if(result.data.msg.indexOf('用户名已存在')>=0){
                        alert('注册失败');
                    }else{
                        alert('注册成功');
                        vue.inited=false;
                        vue.users=result.data.users;
                    }
                }).catch(function(err){
                    //发生错误时调用
                    console.log(err);
                });
            },
            dojsonpost:function(){
                var data = {};
                data.username = this.username;
                data.pwd = this.pwd;
                data.users=this.users;
                var url='doreg.jsp';
                //使用json格式提交参数
                // reguser(data).then(function(result){
                //
                // });
                axios.post(url,data).then(function(result){
                    console.log(result);
                    if(vue.inited){
                        vue.inited=false;
                        vue.users=result.data.users;
                        return;
                    }
                    if(result.data.msg.indexOf('用户名已存在')>=0){
                        alert('注册失败');
                    }else{
                        alert('注册成功');
                        vue.inited=false;
                        vue.users=result.data.users;
                    }
                }).catch(function(err){
                    //发生错误时调用
                    console.log(err);
                });
            }
        },
        mounted: function () {
            console.log('init');
            this.dosubmit();
        }
    });
</script>
</body>
</html>
       