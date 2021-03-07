package com.networking.mc.Exceptions.Service;

public class UserDoesNotExistsException extends RuntimeException {

    /**
     * Represents user does not exists exception
     */
    public UserDoesNotExistsException() {
        super ("User does not exists exception");
    }
}
