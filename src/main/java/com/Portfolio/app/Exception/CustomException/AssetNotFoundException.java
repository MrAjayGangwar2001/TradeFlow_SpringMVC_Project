package com.Portfolio.app.Exception.CustomException;

public class AssetNotFoundException extends RuntimeException {

    public AssetNotFoundException(String msg){
        super(msg);
    }
}
