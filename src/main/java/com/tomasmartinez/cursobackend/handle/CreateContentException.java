package com.tomasmartinez.cursobackend.handle;

public class CreateContentException extends Exception{
    private String message;
    public CreateContentException(String message){
        super("Error al crear: " + message);
    }
}
