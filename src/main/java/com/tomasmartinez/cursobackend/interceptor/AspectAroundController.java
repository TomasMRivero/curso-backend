package com.tomasmartinez.cursobackend.interceptor;

import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Aspect
@Component
@Log4j2
public class AspectAroundController {


    @Pointcut("@within(org.springframework.web.bind.annotation.RestController)")
    void controllerMethod(){};

    @Around("controllerMethod()")
    Object controllerMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        Object ret = joinPoint.proceed();
        long end = System.nanoTime();

        log.info("Se ejecuto el metodo {} con una duracion de {}ms", joinPoint.getSignature().getName(), TimeUnit.NANOSECONDS.toMillis(end-start));
        return ret;
    }
}
