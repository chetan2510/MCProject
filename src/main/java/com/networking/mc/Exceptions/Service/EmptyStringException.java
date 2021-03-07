package com.networking.mc.Exceptions.Service;

public class EmptyStringException extends RuntimeException  {

    /**
     * Represents empty string exception
     */
    public EmptyStringException() {
        super ("Received null or empty input");
    }

}
