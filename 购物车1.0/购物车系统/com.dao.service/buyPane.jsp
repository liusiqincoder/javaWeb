<%@ page import="com.dao.enterties.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/24
  Time: 15:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<%
    User user = (User) session.getAttribute("user");
    session.setAttribute("user", user);
    if (request.getAttribute("result") == null) {
        request.setAttribute("result", "欢迎你，" + user.getName());
    }
%>
<head>
    <meta http-equiv="content-type" charset="utf-8">
    <title>${result}</title>
    <link rel="stylesheet" href="/购物车系统/css/buyPane.css"/>
</head>
<body>
<div class="guideBar">
    <a href="/购物车系统/com.dao.service/buyPane.jsp">主页</a>
    <a href="/购物车系统/com.dao.service/shoppingCar.jsp">购物车</a>
    <a href="/购物车系统/com.dao.service/contactUs.jsp">联系我们</a>
    <a href="/购物车系统/com.dao.service/buyPane.jsp">关于我们</a>
</div>
<div class="showThing">
    <form action="/solveOrder" method="post">
        <img class="myImg" src="/购物车系统/picture/苹果.jpg"/><br>
        <div class="buyBar">
            <input name="name" value="苹果" style="width: 100%" class="addThing">
            <br/>售价：2.5元/斤<br/><input type="submit" value="加入购物车">
        </div>
    </form>
    <%--<input name="test" value="test"/>--%>
    <form action="/solveOrder" method="post">
        <img class="myImg" src="/购物车系统/picture/电视.jpg"/><br>
        <div class="buyBar">
            <input name="name" value="电视" style="width: 100%" class="addThing">
            <br/>售价：9998元<br/><input type="submit" value="加入购物车">
        </div>
    </form>

    <form action="/solveOrder" method="post">
        <img class="myImg" src="/购物车系统/picture/手机.jpg"/><br>
        <div class="buyBar">
            <input name="name" value="手机" style="width: 100%" class="addThing">
            <br/>售价：1988元<br/><input type="submit" value="加入购物车">
        </div>
    </form>

    <form action="/solveOrder" method="post">
        <img class="myImg" src="/购物车系统/picture/电脑.jpg"/><br>
        <div class="buyBar">
            <input name="name" value="电脑" style="width: 100%" class="addThing">
            <br/>售价：9998元<br/><input type="submit" value="加入购物车">
        </div>
    </form>
</div>
</body>

</html>

