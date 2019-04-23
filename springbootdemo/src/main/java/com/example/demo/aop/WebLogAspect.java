package com.example.demo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by kobe on 2019/1/10.
 */
@Aspect
@Component
public class WebLogAspect {
    final private Logger logger = LoggerFactory.getLogger(WebLogAspect.class);
    @Pointcut("execution(public * com.example.demo.service.*(..))")
    public void webLog(){}

    @Around("webLog()")
    public void testAop(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("run testAop");
        pjp.proceed();
    }

}
