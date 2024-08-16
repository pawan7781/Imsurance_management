package com.project.insurance.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
    public static final Logger LOGGER= LoggerFactory.getLogger(LoggingAspect.class);

    @AfterThrowing("execution(* com.project.insurance.service.*.*(..))")
    public void logmethodCrash(JoinPoint jp)
    {
        LOGGER.info( "Method issue occured" + " " +jp.getSignature().getName());
    }
}
