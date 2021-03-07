package com.networking.mc.Exceptions.Service;

public class UserAlreadyExistsException extends RuntimeException {

    /**
     * Represents user already exists exception
     */
    public UserAlreadyExistsException() {
        super ("User already exists exceptions, please choose a different user name");
    }
}
