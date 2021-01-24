package com.networking.mc.service;

import com.networking.mc.model.NotificationMessages;
import com.networking.mc.repository.NotificationMessagesInterface;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    UserService userService;

    @Autowired
    NotificationMessagesInterface notificationMessagesInterface;

    @Autowired
    RescueService rescueService;

    /**
     *
     * @param notification
     */
    public void sendNotificationToUsers(String notification) {
        userService.addNotification(notification);
        NotificationMessages notificationMessages = new NotificationMessages();
        notificationMessages.notificationMessage = notification;
        notificationMessages.receiver = "Users";
        notificationMessagesInterface.save(notificationMessages);

    }

    /**
     *
     * @param notification
     */
    public void sendNotificationToRescuers(String notification) {
        rescueService.addNotification(notification);
        NotificationMessages notificationMessages = new NotificationMessages();
        notificationMessages.notificationMessage = notification;
        notificationMessages.receiver = "Rescuers";
        notificationMessagesInterface.save(notificationMessages);
    }

    public Iterable<NotificationMessages> getAllNotification() {
        return notificationMessagesInterface.findAll();
    }
}
