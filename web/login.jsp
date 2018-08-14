<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<form name="form1" method="post" action="./helloworld">
    <input type="text" name="username" placeholder="请输入用户名"/>
    <input type="password" name="password" placeholder="请输入密码"/>
    <select name="city">
        <option value="xian">西安</option>
        <option value="xianyang">咸阳</option>
    </select>
    <input type="radio" value="男" name="xingbie">男
    <input type="radio" value="女" name="xingbie">女
    <input type="checkbox" value="苹果" name="shuiguo"/>苹果
    <input type="checkbox" value="西瓜" name="shuiguo"/>西瓜
    <input type="color" name="yanse" />喜欢的颜色
    <img src="./yzm" height="32"/><input name="yzm" />
    <button type="submit">提交</button>
</form>
</body>
</html>