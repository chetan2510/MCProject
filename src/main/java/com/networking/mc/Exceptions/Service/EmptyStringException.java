package com.networking.mc.Exceptions.Service;

public class EmptyStringException extends RuntimeException  {

    public EmptyStringException() {
        super ("Received null or empty input");
    }

}
