package com.springmvc.aop;

import com.springmvc.utils.JsonUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：qmf
 * @date ：Created in 2019/8/24 19:03
 * @description：日志切面
 * @modified By：
 */
@Component
@Aspect
@Slf4j
public class LoggerAop {


    //定义切点
    @Pointcut("execution(* com.springmvc.service.Impl.*ServiceImpl.*(..))")
    public void pointCut() {
    }

    //所有controller切点
    @Pointcut("execution(* com.springmvc.controller..*(..))")
    public void controllerCut() {
    }

    /**
     * 前置通知
     *
     * @param jp
     */
    @Before("pointCut()")
    public void before(JoinPoint jp) { // JoinPoint 连接点对象
        //获取前台参数
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("来访ip为: {}：{}", request.getRemoteAddr(), request.getLocalPort());
        log.info("调用{}的{}方法, 方法入参为：{}", request.getRequestURI(), jp.getSignature().getName(), JsonUtil.objectToJson(request.getParameterMap()));
//        log.info("调用" + jp.getTarget() + "的" + jp.getSignature().getName()
//                + "方法，方法入参：" + Arrays.toString(jp.getArgs())); // jp.getArgs()连接点方法参数数组
    }

    /**
     * 后置通知
     *
     * @param jp
     * @param result
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturning(JoinPoint jp, Object result) {
        // 连接点所在目标类
        log.info("调用" + jp.getTarget() + "的" + jp.getSignature().getName() // 连接点方法信息
                + "方法，返回值" + JsonUtil.objectToJson(result));
    }

    /**
     * 环绕通知
     *
     * @param thisJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("controllerCut()")
    public Object around(ProceedingJoinPoint thisJoinPoint) throws Throwable {
        long startTime = System.nanoTime();//纳秒
        Object result = thisJoinPoint.proceed();
        long time = System.nanoTime() - startTime;
        log.info("耗时{} ms", time / 1e6);
        return result;
    }

}
