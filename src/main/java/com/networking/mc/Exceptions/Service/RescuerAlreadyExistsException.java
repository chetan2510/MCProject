package com.networking.mc.Exceptions.Service;

public class RescuerAlreadyExistsException extends RuntimeException {

    /**
     * Represents rescuer already exists exception
     */
    public RescuerAlreadyExistsException() {
        super ("Rescuer already exists exceptions, please choose a different user name");
    }
}
