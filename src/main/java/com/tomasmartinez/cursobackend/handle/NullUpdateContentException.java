package com.tomasmartinez.cursobackend.handle;

public class NullUpdateContentException extends Exception{
    private String message;
    public NullUpdateContentException(){
        super("Los campos nombre y apellido están vacíos");
    }
}
