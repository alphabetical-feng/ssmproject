package com.springmvc.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：qmf
 * @date ：Created in 2019/10/10 20:27
 * @description：拦截器
 * @modified By：
 */
@Slf4j
public class MyInterceptor implements HandlerInterceptor {

    /**
     * 方法之前执行
     *
     * @param request
     * @param response
     * @param handler
     * @return true不拦截，false拦截
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion");
    }
}
