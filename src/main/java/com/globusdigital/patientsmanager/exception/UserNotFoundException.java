package com.globusdigital.patientsmanager.exception;

public class UserNotFoundException extends RuntimeException {
    //SOLID
    public UserNotFoundException(String message) {
        super(message);
    }
}
