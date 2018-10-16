<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/24
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<link rel="stylesheet" href="/购物车系统/css/registerStyle.css"/>
<body class="bg-img">
<div class="div-class">
    <p><font color="#ffc0cb"><b>请输入你的用户名和密码 O(∩_∩)O~~</b></font></p>
    <form action="/register" method="post">
        用户名：<input type="text" name="name" value="路人甲"><br><br>
        密码：&nbsp&nbsp<input type="password" name="password" value="1234"><br><br>
        <input type="submit" value="注册"><input type="reset" value="取消">
        <p style="color:#ff3c2d">${result}</p>
    </form>
</div>
</body>
</html>
