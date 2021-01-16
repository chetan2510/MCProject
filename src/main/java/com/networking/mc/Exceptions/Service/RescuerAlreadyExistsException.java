package com.networking.mc.Exceptions.Service;

public class RescuerAlreadyExistsException extends RuntimeException {

    public RescuerAlreadyExistsException() {
        super ("Rescuer already exists exceptions, please choose a different user name");
    }
}
