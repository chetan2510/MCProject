package com.networking.mc.api;

import com.networking.mc.api.response.NotificationMessage;
import com.networking.mc.model.NotificationMessages;
import com.networking.mc.model.RescueModel;
import com.networking.mc.model.UserModel;
import com.networking.mc.service.AdminService;
import com.networking.mc.service.RescueService;
import com.networking.mc.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;

@RestController
@RequestMapping("/admin")
public class AdminAPI {

    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    @Autowired
    RescueService rescueService;

    private final Logger logger = LoggerFactory.getLogger(UserAPI.class);

    /**
     * TODO: Try to use mqtt if possible
     *
     * @param notification
     *
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/sendNotificationtousers", method = RequestMethod.POST)
    public NotificationMessage sendNotificationToUser(@RequestParam String notification) {
        adminService.sendNotificationToUsers(notification);
        logger.info("Request received at " + Instant.now() + "at /sendnotificationtousers api");
        return new NotificationMessage("Notification sent to users");
    }

    /**
     * TODO: Try to use mqtt if possible
     *
     * @param notification
     *
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/sendnotificationtorescuers", method = RequestMethod.POST)
    public NotificationMessage sendNotificationToRescuer(@RequestParam String notification) {
        adminService.sendNotificationToRescuers(notification);
        logger.info("Request received at " + Instant.now() + "at /sendnotificationtorescuers api");
        return new NotificationMessage("Notification sent to rescuers");
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/getallnotifications", method = RequestMethod.GET)
    public Iterable<NotificationMessages> getAllNotification() {
        logger.info("Request received at " + Instant.now() + "at /getallnotifications api");
        return adminService.getAllNotification();
    }

}
