package com.networking.mc.model;


import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class NotificationMessages {

    @Id @GeneratedValue @NotNull
    public long id;

    @NotNull
    public String notificationMessage;

    @NotNull
    public String receiver;

    public NotificationMessages() {}
}
