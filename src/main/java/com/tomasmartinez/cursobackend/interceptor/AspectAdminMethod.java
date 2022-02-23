package com.tomasmartinez.cursobackend.interceptor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectAdminMethod {
    Logger logger = LogManager.getLogger(AspectAdminMethod.class);

    @Pointcut("@annotation(com.tomasmartinez.cursobackend.annotation.AdminMethod)")
    void updateOrDeleteServiceMethods(){};

    @After("updateOrDeleteServiceMethods()")
    void afterAdviceMethod(){
        logger.info("Se ejecuto metodo de administrador");
    }
}
