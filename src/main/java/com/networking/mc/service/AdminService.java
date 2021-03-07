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
     * Sends notification to the users
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
     * Sends notification to the rescuers
     * @param notification
     */
    public void sendNotificationToRescuers(String notification) {
        rescueService.addNotification(notification);
        NotificationMessages notificationMessages = new NotificationMessages();
        notificationMessages.notificationMessage = notification;
        notificationMessages.receiver = "Rescuers";
        notificationMessagesInterface.save(notificationMessages);
    }

    /**
     * Method gets all the notificartions
     * @return
     */
    public Iterable<NotificationMessages> getAllNotification() {
        return notificationMessagesInterface.findAll();
    }
}
