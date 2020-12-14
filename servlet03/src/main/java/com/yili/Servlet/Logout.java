package com.yili.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Object username = req.getSession().getAttribute("USERID");
        if(username!=null){
            req.getSession().removeAttribute("USERID");
            resp.sendRedirect("/servlet03_war/Login.jsp");
        }else{
            resp.sendRedirect("/servlet03_war/Login.jsp");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
