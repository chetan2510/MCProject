package com.networking.mc.api;

import com.networking.mc.api.response.GeneralResponseMessage;
import com.networking.mc.api.response.MultipleuserAddedresponse;
import com.networking.mc.model.NotificationMessages;
import com.networking.mc.model.UserModel;
import com.networking.mc.service.UserService;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;

@RestController // Marks this class that it has controllers inside it
@RequestMapping("/user")
public class UserAPI {

    private final Logger logger = LoggerFactory.getLogger(UserAPI.class);

    @Autowired
    private UserService userService;

    /**
     * To add a user
     * @param userModel
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public GeneralResponseMessage addUser(@RequestBody UserModel userModel) {
        logger.info("Request received at " + Instant.now() + "at /adduser api");
        return new GeneralResponseMessage(userService.addUserToList(userModel));

    }

    /**
     * To get a user
     * @param username
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getuser/{username}", method = RequestMethod.GET)
    public UserModel getUser(@PathVariable @NonNull String  username) {
        logger.info("Request received at " + Instant.now() + "at /getuser api");
        return userService.getUser(username);
    }

    /**
     * To delete a user
     * @param username
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/deleteuser", method = RequestMethod.DELETE)
    public GeneralResponseMessage deleteUser(@RequestParam @NonNull String username) {
        userService.deleteUser(username);
        logger.info("Request received at " + Instant.now() + "at /deleteuser api");
        return new GeneralResponseMessage("User deleted successfully");
    }

    /**
     * To get all users
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getallusers", method = RequestMethod.GET)
    public Iterable<UserModel> getAllUsers() {
        logger.info("Request received at " + Instant.now() + "at /getallusers api");
       return userService.getUserList();
    }

    /**
     * To add multiple users
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/addmultipleusers", method = RequestMethod.GET)
    public MultipleuserAddedresponse addMultipleUsers() {
            userService.addMultipleUsers();
        logger.info("Request received at " + Instant.now() + "at /addmultipleusers api");
            return new MultipleuserAddedresponse("Multiple user added successfully");
    }

    /**
     * To get user notification
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getusernotification", method = RequestMethod.GET)
    public NotificationMessages getNotification() {
        logger.info("Request received at " + Instant.now() + "at /getusernotification api");
        NotificationMessages notificationMessages = new NotificationMessages();
        if(userService.getNotification() == null) {
            notificationMessages.notificationMessage = "";
        } else {
            notificationMessages.notificationMessage = userService.getNotification();
        }
        return  notificationMessages;
    }

    /**
     * To clear all users
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/clearallusers", method = RequestMethod.GET)
    public GeneralResponseMessage clearAllUsers() {
        logger.info("Request received at " + Instant.now() + "at /clearallusers api");
         userService.deleteAll();
         return new GeneralResponseMessage("All users cleared successfully");
    }

}
