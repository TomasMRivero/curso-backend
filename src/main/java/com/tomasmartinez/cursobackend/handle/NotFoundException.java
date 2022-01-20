package com.tomasmartinez.cursobackend.handle;

public class NotFoundException extends Exception{
    private String message;
    public NotFoundException(String message){
        super(message);
    }
}
