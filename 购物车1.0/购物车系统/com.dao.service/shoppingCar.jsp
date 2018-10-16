<%@ page import="java.util.ArrayList" %>
<%@ page import="com.dao.enterties.thing" %>
<%@ page import="com.dao.enterties.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="format-detection" content="telephone=no">
    <meta name="viewport" content="user-scalable=no, width=device-width, initial-scale=1.0, maximum-scale=1.0">
    <title>${sessionScope.user.getName()}的购物车</title>

    <script type="text/javascript" src="../购物车结算前端/js/jquery-2.1.4.min.js"></script>
    <script type="text/javascript" src="../购物车结算前端/js/shopping.js"></script>
    <script type="text/javascript" src="../购物车结算前端/js/shoppingStyle.js"></script>

    <link type="text/css" rel="stylesheet" href="../购物车结算前端/css/base.css"/>
    <link type="text/css" rel="stylesheet" href="../购物车结算前端/css/module.css"/>

</head>
<body>

<!--头部开始-->
<div class="header">
    <h1>购物车</h1>
    <a href="#" class="back"><span></span></a>
    <a href="#" class=""></a>
</div>
<!--头部结束-->
<div class="shopping">

    <div class="shop-group-item">
        <div class="shop-name">
            <input type="checkbox" class="check goods-check shopCheck">
            <h4><a href="#">我的购物车</a></h4>
            <div class="coupons"><span>领券</span><em>|</em><span>编辑</span></div>
        </div>
        <ul id="shoppingList">
            <%
                ArrayList<thing> things = ((User) request.getSession().getAttribute("user")).getBuyThing();
                for (int i = 0; i < things.size(); i++) {
//					String img=things.get(i).getName();
//					System.out.println(img);
                    out.println("<li>");
                    out.println("<div class=\"shop-info\">");
                    out.println("<input type=\"checkbox\" class=\"check goods-check goodsCheck\">");
                    out.println("<div class=\"shop-info-img\"><a href=\"#\"><img src=\"/购物车系统/picture/" + things.get(i).getName() + ".jpg\" /></a></div>");
                    out.println("<div class=\"shop-info-text\">");
                    out.println("<h4>" + things.get(i).getDescription() + "</h4>");
//					out.println("<div class=\"shop-brief\"><span>重量:3.3kg</span><span>颜色:标配版</span><span>版本:13.3英寸</span></div>");
                    out.println("<div class=\"shop-price\">");
                    out.println("<div class=\"shop-pices\">￥<b class=\"price\">" + things.get(i).getPrice() + "</b></div>");
                    out.println("<div class=\"shop-arithmetic\">");
                    out.println("<a href=\"/dropNum?name=" + things.get(i).getName() + "\" class=\"minus\">-</a>");
                    out.println("<span class=\"num\" >" + things.get(i).getNum() + "</span>");
                    out.println("<a href=\"/addNum?name=" + things.get(i).getName() + "\" class=\"plus\">+</a>");
                    out.println("</div>");
                    out.println("</div>");
                    out.println("</div>");
                    out.println("</div>");
                    out.println("</li>");
                }
                out.println("<div class=\"shopPrice\">本店总计：￥" +
                        "<span class=\"shop-total-amount ShopTotal\">0.00</span></div>");

            %>
        </ul>
    </div>
    <div class="payment-bar">
        <div class="all-checkbox"><input type="checkbox" class="check goods-check" id="AllCheck">全选</div>
        <div class="shop-total">
            <strong>总价：<i class="total" id="AllTotal">0.00</i></strong>
            <span>减免：123.00</span>
        </div>
        <a href="/settlement" class="settlement">结算</a>
    </div>
</div>
</body>
</html>

