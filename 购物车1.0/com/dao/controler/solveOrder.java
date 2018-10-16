package com.dao.controler;

import com.dao.enterties.User;
import com.dao.enterties.userOrder;
import sun.plugin.com.Dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2018/9/29.
 */
@WebServlet(name = "/solveOrder", urlPatterns = "/solveOrder")
public class solveOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        request.setCharacterEncoding("utf-8");
        String thingName = request.getParameter("name");
        int num = 1;
//        String test="中文";
//        System.out.println(thingName+","+num+","+test);
        user.buy(thingName, num);
        response.setContentType("text/html");
        response.getWriter().print("<html><script>window.history.go(-1)</script></html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
