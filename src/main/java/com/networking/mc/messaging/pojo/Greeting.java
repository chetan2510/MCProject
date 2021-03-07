package com.networking.mc.messaging.pojo;

/**
 * Greeting class used in web socket.
 */
public class Greeting {

    private String content;

    public Greeting() {
    }

    public Greeting(String content) {

        this.content = content;
    }

    public String getContent() {

        return content;
    }

}
