package com.tomasmartinez.cursobackend.handle;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

@ControllerAdvice
@Log4j2
public class ErrorMsgHandle {

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMsg errorMsgHandle(NotFoundException ex){
        log.error(ex.getMessage());
        return new ErrorMsg(ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(UpdateContentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMsg errorMsgHandle(UpdateContentException ex) {
        log.error(ex.getMessage());
        return new ErrorMsg(ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(CreateContentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorMsg errorMsgHandle(CreateContentException ex) {
        log.error(ex.getMessage());
        return new ErrorMsg(ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(LoginException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ErrorMsg errorMsgHandle(LoginException ex) {
        log.error(ex.getMessage());
        return new ErrorMsg(ex.getMessage());
    }

}
