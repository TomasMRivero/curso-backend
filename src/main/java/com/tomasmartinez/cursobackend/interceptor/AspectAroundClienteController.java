package com.tomasmartinez.cursobackend.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class AspectAroundClienteController {
//    Logger logger = LogManager.getLogger(AspectAroundClienteController.class);
//
//    @Pointcut("execution(* com.tomasmartinez.cursobackend.controller.ClienteController.*(..)) && " +
//             "!execution(* com.tomasmartinez.cursobackend.controller.ClienteController.deleteClient(..))")
//    void controllerClassMethodsNoDelete(){};
//
//    @Around("controllerClassMethodsNoDelete()")
//    Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        long start = System.nanoTime();
//        Object ret = joinPoint.proceed();
//        long end = System.nanoTime();
//
//        logger.info("Se ejecuto el metodo {} con una duracion de {}ms", joinPoint.getSignature().getName(), TimeUnit.NANOSECONDS.toMillis(end-start));
//        return ret;
//    }
}
