package com.project.insurance.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class PerformanceMonitorAspect {
    public static final Logger LOGGER= LoggerFactory.getLogger(PerformanceMonitorAspect.class);
    @Around("execution(* com.project.insurance.service.*.*(..))")
    public Object executiontime(ProceedingJoinPoint jp) throws Throwable {
        long startTime=System.currentTimeMillis();
        Object obj=jp.proceed();
        long endTime=System.currentTimeMillis();
        LOGGER.info("Execution time of "+jp.getSignature().getName() +" in "+(endTime-startTime)+" ms");
        return obj;
    }
}
