package com.springmvc.utils.filterAndInterceptor;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：qmf
 * @date ：Created in 2019/10/10 20:18
 * @description：跨域
 * @modified By：
 */
public class WebContextFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Allow-Methods", "OPTIONS,GET,POST,DELETE,PUT");
        resp.setHeader("Access-Control-Allow-Headers", "accept,content-type,Content-Type,x-requested-with");
        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
