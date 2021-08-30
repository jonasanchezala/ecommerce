package com.napptilus.ecommerce.service.exception;

public class PriceNotFoundException extends RuntimeException{
    public PriceNotFoundException(String message) {
        super(message);
    }
}
