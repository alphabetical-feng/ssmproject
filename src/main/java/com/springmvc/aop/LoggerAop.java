package com.springmvc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author ：qmf
 * @date ：Created in 2019/8/24 19:03
 * @description：日志切面
 * @modified By：
 */
@Component
@Aspect
public class LoggerAop {

    private static final Logger log = LoggerFactory.getLogger(LoggerAop.class);

    //定义切点
    @Pointcut("execution(* com.springmvc.service.Impl.*ServiceImpl.*(..))")
    public void pointCut() {
    }

    /**
     * 前置通知
     *
     * @param jp
     */
    @Before("pointCut()")
    public void before(JoinPoint jp) { // JoinPoint 连接点对象
        log.info("调用" + jp.getTarget() + "的" + jp.getSignature().getName()
                + "方法，方法入参：" + Arrays.toString(jp.getArgs())); // jp.getArgs()连接点方法参数数组
    }

    /**
     * 前置通知
     *
     * @param jp
     * @param result
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturning(JoinPoint jp, Object result) {
        // 连接点所在目标类
        log.info("调用" + jp.getTarget() + "的" + jp.getSignature().getName() // 连接点方法信息
                + "方法，返回值" + result);
    }
}
