package com.example.testservice;


public class CommonResponse {
    boolean status;
    String message;

    public CommonResponse(boolean status,String message){
        this.status=status;
        this.message=message;

    }

    public boolean getStatus(){
        return status;
    }

    public String getMessage(){
        return message;
    }
}
