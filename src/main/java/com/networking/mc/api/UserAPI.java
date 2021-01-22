package com.networking.mc.api;

import com.networking.mc.api.response.GeneralResponseMessage;
import com.networking.mc.api.response.MultipleuserAddedresponse;
import com.networking.mc.model.UserModel;
import com.networking.mc.service.UserService;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.Instant;
import java.util.LinkedHashMap;


@RestController // Marks this class that it has controllers inside it
@RequestMapping("/user")
public class UserAPI {

    private final Logger logger = LoggerFactory.getLogger(UserAPI.class);

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public GeneralResponseMessage addUser(@RequestBody UserModel userModel) {
        logger.info("Request received at " + Instant.now() + "at /adduser api");
        return new GeneralResponseMessage(userService.addUserToList(userModel));

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getuser/{username}", method = RequestMethod.GET)
    public UserModel getUser(@PathVariable @NonNull String  username) {
        logger.info("Request received at " + Instant.now() + "at /getuser api");
        return userService.getUser(username);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/deleteuser", method = RequestMethod.DELETE)
    public GeneralResponseMessage deleteUser(@RequestParam @NonNull String username) {
        userService.deleteUser(username);
        logger.info("Request received at " + Instant.now() + "at /deleteuser api");
        return new GeneralResponseMessage("User deleted successfully");
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getallusers", method = RequestMethod.GET)
    public Iterable<UserModel> getAllUsers() {
        logger.info("Request received at " + Instant.now() + "at /getallusers api");
       return userService.getUserList();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/addmultipleusers", method = RequestMethod.GET)
    public MultipleuserAddedresponse addMultipleUsers() {
            userService.addMultipleUsers();
        logger.info("Request received at " + Instant.now() + "at /addmultipleusers api");
            return new MultipleuserAddedresponse("Multiple user added successfully");
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getusernotification", method = RequestMethod.GET)
    public LinkedHashMap<String , String> getNotification() {
        logger.info("Request received at " + Instant.now() + "at /getusernotification api");
        return userService.notificationMap;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/clearallusers", method = RequestMethod.GET)
    public GeneralResponseMessage clearAllUsers() {
        logger.info("Request received at " + Instant.now() + "at /clearallusers api");
         userService.deleteAll();
         return new GeneralResponseMessage("All users cleared successfully");
    }

}
