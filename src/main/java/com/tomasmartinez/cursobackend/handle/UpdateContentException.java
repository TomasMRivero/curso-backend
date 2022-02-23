package com.tomasmartinez.cursobackend.handle;

public class UpdateContentException extends Exception{
    private String message;
    public UpdateContentException(String message){
        super("Error al actualizar: " + message);
    }
}
