package com.tomasmartinez.cursobackend.handle;

public class LoginException extends Exception{
    private String message;
    public LoginException(String message){
        super("Error al iniciar sesión: " + message);
    }
}
