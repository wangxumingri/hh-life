package com.wxss.hhlife.dubbo.merchant.exception;

public class ServiceException extends Exception{

    private String message;

    public ServiceException(String message) {
        super(message);
        this.message = message;
    }
}
