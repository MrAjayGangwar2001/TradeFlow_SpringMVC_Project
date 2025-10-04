package com.Portfolio.app.Exception.CustomException;

public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(String msg){
        super(msg);
    }
}
