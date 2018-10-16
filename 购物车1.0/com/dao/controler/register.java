package com.dao.controler;

import com.dao.enterties.DBUtil;
import com.dao.enterties.User;
import com.dao.enterties.userUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2018/9/24.
 */
@WebServlet(name = "/register", urlPatterns = "/register")
public class register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       /* request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String name=request.getParameter("name"),pwd=request.getParameter("password");
        System.out.println(name+","+pwd);
        User user=new User(name,pwd);
        String result;
        if(!userUtil.addUser(DBUtil.getStat(),user)){
            result="用户已存在，注册失败";
        }else{
            result="注册成功";
        }
        request.setAttribute("result",result);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/购物车系统/com.dao.service/register.jsp");
        dispatcher.forward(request,response);*/
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String name = request.getParameter("name"), pwd = request.getParameter("password");
        System.out.println(name + "," + pwd);
        User user = new User(name, pwd);
        String result;
        if (!userUtil.addUser(DBUtil.getStat(), user)) {
            result = "用户已存在，注册失败";
        } else {
            result = "注册成功";
        }
       /* request.setAttribute("result",result);
        RequestDispatcher dispatcher=request.getRequestDispatcher("/购物车系统/index.jsp");
        dispatcher.forward(request,response);*/
        response.setContentType("text/html");
        response.getWriter().print("<html><script>window.history.go(-1)</script></html>");
    }
}
