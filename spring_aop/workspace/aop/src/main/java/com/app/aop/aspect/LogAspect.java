package com.app.aop.aspect;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Configuration
@Slf4j
public class LogAspect {
//    @Before("@annotation(com.app.aop.aspect.annotation.LogStatus)")
//    public void beforeStart(JoinPoint joinPoint){
//        log.info("join point: " + joinPoint);
//        log.info("method name: " + joinPoint.getSignature().getName());
//        log.info("arguments: " + Arrays.stream(joinPoint.getArgs()).map(String::valueOf).collect(Collectors.joining(", ")));
//    }

//    @After("logStatusAnnotated()")
//    public void afterStart(JoinPoint joinPoint){
//        log.info("join point: " + joinPoint);
//        log.info("method name: " + joinPoint.getSignature().getName());
//        log.info("arguments: " + Arrays.stream(joinPoint.getArgs()).map(String::valueOf).collect(Collectors.joining(", ")));
//    }

//    @AfterReturning(value = "logStatusAnnotated()", returning = "result")
//    public void afterStart(JoinPoint joinPoint, Integer result){
//        log.info("join point: " + joinPoint);
//        log.info("method name: " + joinPoint.getSignature().getName());
//        log.info("arguments: " + Arrays.stream(joinPoint.getArgs()).map(String::valueOf).collect(Collectors.joining(", ")));
//        log.info("return value: " + result);
//    }

//    @AfterThrowing(value = "logStatusAnnotated()", throwing = "e")
//    public void afterStart(Exception e){
//        log.info(e.getMessage());
//        log.info("wrong parameter");
//    }

    @Around("logStatusAnnotated()")
    public Integer around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("join point: {}", joinPoint);
        Integer result = 0;

        result = (Integer)joinPoint.proceed();

        return result + 10;
    }

    @Pointcut("@annotation(com.app.aop.aspect.annotation.LogStatus)")
    public void logStatusAnnotated(){}
}
