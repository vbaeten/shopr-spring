package com.realdolmen.shoprbackend.exception;


public class NotFoundException extends RuntimeException{


    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException() {
    }
}
