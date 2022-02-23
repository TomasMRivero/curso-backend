package com.tomasmartinez.cursobackend.handle;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorMsgHandle {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMsg errorMsgHandle(NotFoundException ex){
        return new ErrorMsg(ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(UpdateContentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMsg errorMsgHandle(UpdateContentException ex){
        return new ErrorMsg(ex.getMessage());
    }
}
