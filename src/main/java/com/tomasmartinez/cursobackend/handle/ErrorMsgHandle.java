package com.tomasmartinez.cursobackend.handle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorMsgHandle {
    private static final Logger logger = LogManager.getLogger(ErrorMsgHandle.class);

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMsg errorMsgHandle(NotFoundException ex){
        return new ErrorMsg(ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(NullUpdateContentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMsg errorMsgHandle(NullUpdateContentException ex){
        return new ErrorMsg(ex.getMessage());
    }
}
