package com.networking.mc.api;

import com.networking.mc.api.response.GeneralResponseMessage;
import com.networking.mc.api.response.MultipleuserAddedresponse;
import com.networking.mc.model.UserModel;
import com.networking.mc.service.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.LinkedList;


@RestController // Marks this class that it has controllers inside it
@RequestMapping("/user")
public class UserAPI {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String addUser(@RequestBody UserModel userModel) {
        userService.addUserToList(userModel);
        return "User added successfully";
    }

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
        System.out.println("Users fetched api called");
       return userService.getUserList();
    }

    @RequestMapping(value = "/updateuserlocation", method = RequestMethod.POST)
    public String updateLocation(@RequestBody UserModel userModel) {
        userService.updateUserLocation(userModel);
        return "User location updated successfully";
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/addmultipleusers", method = RequestMethod.GET)
    public MultipleuserAddedresponse addMultipleUsers() {
            userService.addMultipleUsers();
            return new MultipleuserAddedresponse("Multiple user added successfully");
    }

    @RequestMapping(value = "/getUserNotification", method = RequestMethod.GET)
    public String getNotification() {
        return userService.notification.equals("") ? "":userService.notification;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/clearallusers", method = RequestMethod.GET)
    public GeneralResponseMessage clearAllUsers() {
         userService.deleteAll();
         return new GeneralResponseMessage("All users cleared successfully");
    }

}
