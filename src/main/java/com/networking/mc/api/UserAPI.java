package com.networking.mc.api;

import com.networking.mc.api.response.GeneralResponseMessage;
import com.networking.mc.api.response.MultipleuserAddedresponse;
import com.networking.mc.api.response.NotificationMessage;
import com.networking.mc.model.UserModel;
import com.networking.mc.service.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;


@RestController // Marks this class that it has controllers inside it
@RequestMapping("/user")
public class UserAPI {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public GeneralResponseMessage addUser(@RequestBody UserModel userModel) {
        return new GeneralResponseMessage(userService.addUserToList(userModel));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getuser/{username}", method = RequestMethod.GET)
    public UserModel getUser(@PathVariable @NonNull String  username) {
        return userService.getUser(username);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/deleteuser", method = RequestMethod.DELETE)
    public GeneralResponseMessage deleteUser(@RequestParam @NonNull String username) {
        userService.deleteUser(username);
        return new GeneralResponseMessage("User deleted successfully");
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getallusers", method = RequestMethod.GET)
    public Collection<UserModel> getAllUsers() {
       return userService.getUserList();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/addmultipleusers", method = RequestMethod.GET)
    public MultipleuserAddedresponse addMultipleUsers() {
            userService.addMultipleUsers();
            return new MultipleuserAddedresponse("Multiple user added successfully");
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getusernotification", method = RequestMethod.GET)
    public NotificationMessage getNotification() {
        NotificationMessage notificationMessage = new NotificationMessage("");
        if(userService.notification.equals("")) {
            return  notificationMessage;
        } else {
            notificationMessage.notificationMessage=userService.notification;
            return  notificationMessage;
        }
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/clearallusers", method = RequestMethod.GET)
    public GeneralResponseMessage clearAllUsers() {
         userService.deleteAll();
         return new GeneralResponseMessage("All users cleared successfully");
    }

}
