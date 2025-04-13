package com.example.books.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LoggingAspect {

    @Pointcut("within(com.example.books.controller.BookController)")
    public void loggingUserController() {
    }

    @Around("loggingUserController()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        log.info(String.format("Вызван метод %s", joinPoint.getSignature().getName()));
        log.info(String.format("Входные параметры метода:", Arrays.toString(joinPoint.getArgs())));

        Object returnedObject = joinPoint.proceed();

        log.info(String.format("Метод %s отработал и вернул %s", methodName, returnedObject));
        return returnedObject;
    }

}
