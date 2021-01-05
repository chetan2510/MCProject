package com.networking.mc.Exceptions.Service;

public class UserDoesNotExistsException extends RuntimeException {

    public UserDoesNotExistsException() {
        super ("User does not exists exception");
    }
}
