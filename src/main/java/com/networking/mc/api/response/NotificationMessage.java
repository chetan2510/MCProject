package com.networking.mc.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotificationMessage {

    public String notificationMessage;

    public NotificationMessage(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }

}
