package com.tomasmartinez.cursobackend.handle;

public class FirstApplicationException extends Exception {
    private String message;
    public FirstApplicationException(String message){
        super(message);
    }
}
