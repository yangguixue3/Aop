package com.msr.myException;

public class  CustomException extends Exception{

    private String message;

    public CustomException() {

    }

    public CustomException(String message) {
        this.message= message;
    }

    @Override
    public String getMessage() {
        return message;
    }


}
