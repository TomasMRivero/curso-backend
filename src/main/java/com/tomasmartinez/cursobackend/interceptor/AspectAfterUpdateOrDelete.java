package com.tomasmartinez.cursobackend.interceptor;

import com.tomasmartinez.cursobackend.handle.UpdateContentException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectAfterUpdateOrDelete {
    Logger logger = LogManager.getLogger(AspectAfterUpdateOrDelete.class);

    @Pointcut("@annotation(com.tomasmartinez.cursobackend.annotation.UpdateOrDelete)")
    void updateOrDeleteServiceMethods(){};

    @After("updateOrDeleteServiceMethods()")
    void afterAdviceMethod(){
        logger.info("Se ejecuto el after advice de un metodo Update o Delete del Service");
    }
    @AfterThrowing(value = "updateOrDeleteServiceMethods()", throwing = "updateContentException")
    void afterThrowingAdviceMethod(UpdateContentException updateContentException){
        logger.error("Error: {}", updateContentException.getMessage());
    }
}
