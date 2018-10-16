package com.dao.controler;

import com.dao.enterties.User;
import com.dao.enterties.userUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2018/9/23.
 */
@WebServlet(name = "/exisitsUser", urlPatterns = "/exisitsUser")
public class exisitsUser extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//        super.doPost(request,response);
        User user = new User(request.getParameter("name"),
                request.getParameter("password"));
        if (!userUtil.exisitsUser(user)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher
                    ("/购物车系统/com.dao.service/lopgin.jsp");
            request.setAttribute("result", "密码错误，请重新输入");
            dispatcher.forward(request, response);
        } else {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html;character:utf-8");
            out.println("<p style=\"top:50%;left:50%\">" +
                    "登陆成功,欢迎你[" + user.getName() + "]用户</p>");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/购物车系统/com.dao.service/buyPane.jsp");
            request.setAttribute("user", user);
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
//        super.doPost(request,response);
        User user = new User(request.getParameter("name"),
                request.getParameter("password"));
        if (!userUtil.exisitsUser(user)) {
//            request.setAttribute("result", "密码错误，请重新输入");
            response.setContentType("text/html");
            response.getWriter().print("<html><script>window.history.go(-1);alert('密码错误，请重新输入')</script></html>");
        } else {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html;character:utf-8");
            out.println("<p style=\"top:50%;left:50%\">" +
                    "登陆成功,欢迎你[" + user.getName() + "]用户</p>");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/购物车系统/com.dao.service/buyPane.jsp");
            request.getSession().setAttribute("user", user);
            dispatcher.forward(request, response);
        }
    }
}
