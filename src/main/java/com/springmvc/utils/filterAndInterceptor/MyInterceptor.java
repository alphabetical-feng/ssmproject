package com.springmvc.utils.filterAndInterceptor;

import com.springmvc.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StopWatch;
import org.springframework.web.method.HandlerMethod;
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
    //计时工具
    private ThreadLocal<StopWatch> stopWatch = new ThreadLocal<>();

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
        StopWatch sw = new StopWatch();
        stopWatch.set(sw);
        sw.start();
        String method = handler.getClass().getSimpleName();
        if (handler instanceof HandlerMethod) {
            String beanType = ((HandlerMethod) handler).getBeanType().getName();
            String methodName = ((HandlerMethod) handler).getMethod().getName();
            method = beanType + "." + methodName;
        }
        log.info("来访ip为: {}：{}", request.getRemoteAddr(), request.getLocalPort());
        log.info("调用[{}]-->[{}]，方法入参{}", method, request.getRequestURI(), JsonUtil.objectToJson(request.getParameterMap()));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        stopWatch.get().stop();
        stopWatch.get().start();
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        StopWatch sw = stopWatch.get();
        sw.stop();
        log.info("一共耗时：{}ms，方法耗时：{}ms，视图呈现：{}ms", sw.getTotalTimeMillis(),
                sw.getTotalTimeMillis() - sw.getLastTaskTimeMillis(), sw.getLastTaskTimeMillis());
        stopWatch.remove();
    }
}
