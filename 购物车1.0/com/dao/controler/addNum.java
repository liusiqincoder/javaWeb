package com.dao.controler;

import com.dao.enterties.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Administrator on 2018/10/4.
 */
@WebServlet(name = "/addNum", urlPatterns = "/addNum")
public class addNum extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        User user = (User) request.getSession().getAttribute("user");
        String name = request.getParameter("name");
        user.addNum(name);
        response.setContentType("text/html");
        response.getWriter().print("<html><script>window.history.go(-1)</script></html>");
    }
}
