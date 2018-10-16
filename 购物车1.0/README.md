# 前言
这是在国庆时学完jsp和servlet做的一个小demo，打算练一下mvc分层，等以后有时间在弄好点
用的是jsp+servet+mysql
前端的效果是我在网上找的

#  效果展示
登陆页面

注册页面

购买页面

购物车页面

数据库里的订单数据


    以及注册数据
    
    
#  分包
<li>com.dao.controller存放的是servlet，用来控制业务逻辑，比如用户注册，登陆处理，订单处理等请求
<li>com.dao.enterties存放的是实体类，存放和处理数据的载体，比如数据库工具类，商品，购物车类，用户类等
<li>com.dao.service页面展示层，存放前端页面和处理结果

#  数据库
主要有两个表
用户表user
CREATE TABLE `user` (
  `name` varchar(10) NOT NULL,
  `password` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8

订单表userOrder
CREATE TABLE `userorder` (
  `userName` varchar(10) NOT NULL,
  `thingName` varchar(10) NOT NULL,
  `num` int(11) DEFAULT NULL,
  `buyDate` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8

#  不足
<li>登陆和注册页面缺乏提示
<li>购物车里面进去的时候没初始化
    那时候没注意到这点，只要加个购物车数据库和几个类就行了
<li>购买界面是我写的，确实有点菜，以后改进
     而且购买的东西里面写好的，没法添加更多东西
     应该加一个商品表，在展示商品这一块需要多借鉴一下别人
     同时还得添加一个管理者身份，可以管理商品（这点够呛，，，）
 <li>还有一些其他的比如联系我们这些没弄好
 
