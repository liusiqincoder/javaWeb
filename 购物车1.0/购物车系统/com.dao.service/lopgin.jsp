<%@ page import="com.dao.enterties.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/22
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="content-type" charset="utf-8">
    <title>用户登录</title>
    <link rel="stylesheet" href="/购物车系统/css/loginStyle.css"/>
</head>
<body class="bg-img">

<div class="pos">
    <p><font color="#ffc0cb"><b>请输入你的用户名和密码 O(∩_∩)O~~</b></font></p>
    <form action="/exisitsUser" method="post">
        用户名：<input type="text" name="name" value="路人甲"><br><br>
        密码：&nbsp&nbsp<input type="password" name="password" value="1234"><br><br>
        <input type="submit" value="登录"><input type="reset" value="取消">
        <p style="color:#ff3c2d">${result}</p>
    </form>

    <span class="spanClass"><a href="/购物车系统/com.dao.service/register.jsp">还没注册？</a></span>
</div>
<%--<jsp:useBean id="user" class="com.dao.enterties.User" scope="request" />
<jsp:setProperty name="user" property="*" />
<%
       request.setAttribute("user",user);
       System.out.println(user.getName()+":"+user.getPassword());
%>--%>
</body>
</html>
