package com.Portfolio.app.Exception.CustomException;

public class UserIdNotFoundException extends RuntimeException {
    
    public UserIdNotFoundException(String message){
        super(message);
    }
}
