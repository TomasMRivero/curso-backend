package com.tomasmartinez.cursobackend.handle;

public class ErrorMsg {
    private String error;

    public ErrorMsg(String error){
        this.error = error;
    }

    public String getError(){
        return this.error;
    }
}
