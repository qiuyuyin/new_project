package com.yili.Filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class First_Filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化过滤器");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = servletResponse.getWriter();
        writer.println("进入过滤器");
        filterChain.doFilter(servletRequest,servletResponse);
        writer.println("离开过滤器");
    }

    @Override
    public void destroy() {
        System.out.println("销毁过滤器");
    }
}
