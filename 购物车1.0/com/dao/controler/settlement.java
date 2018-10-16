package com.dao.controler;

import com.dao.enterties.User;
import com.dao.enterties.thing;
import com.dao.enterties.userOrder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Administrator on 2018/10/4.
 */
@WebServlet(name = "/settlement", urlPatterns = "/settlement")
public class settlement extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        ArrayList<thing> items = user.getBuyThing();
        for (thing t : items) {
            userOrder.addOrder(user.getName(), t.getName(), t.getNum());
        }
        PrintWriter out=response.getWriter();
        response.setContentType("text/html");
        out.print("<html><script>window.history.go(-1)</script></html>");
    }
}
