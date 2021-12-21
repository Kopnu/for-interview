package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Aop logger.
 *
 * @author Sergei_Kornilov
 */
@Slf4j
@Aspect
@Component
public class ServiceLogger {

    @Pointcut("within(com.example.demo.service..*)")
    public void services() {
    }

    @Pointcut("within(com.example.demo.resource..*)")
    public void resources() {
    }

    @Around("services() && resources()")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("{} {}() - start: arguments {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                Arrays.toString(joinPoint.getArgs()));

        Object returnValue = joinPoint.proceed();

        log.info("{} {}() - end: return value {}",
                joinPoint.getSignature().getDeclaringTypeName(),
                joinPoint.getSignature().getName(),
                returnValue);


        return returnValue;
    }

}
