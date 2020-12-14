package com.yili.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class Listener_Test implements HttpSessionListener {
    private int count = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        count++;
        System.out.println("监听器创建！");
        ServletContext servletContext = se.getSession().getServletContext();
        servletContext.setAttribute("count", new Integer(count));
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        count--;
        System.out.println("监听器销毁");
        ServletContext servletContext = se.getSession().getServletContext();
        servletContext.setAttribute("count",new Integer(count));
    }
}
