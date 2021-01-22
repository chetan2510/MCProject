package com.networking.mc.service;

import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    UserService userService;

    @Autowired
    RescueService rescueService;

    /**
     *
     * @param notification
     */
    public void sendNotificationToUsers(String notification) {
        if(!StringUtil.isNullOrEmpty(notification))
        userService.addNotification(notification);
    }

    /**
     *
     * @param notification
     */
    public void sendNotificationToRescuers(String notification) {
        if(!StringUtil.isNullOrEmpty(notification))
            rescueService.addNotification(notification);
    }
}
