package com.networking.mc.api;

import com.networking.mc.model.UserModel;
import com.networking.mc.service.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;


@RestController // Marks this class that it has controllers inside it
public class RestUserController {

    @Autowired
    private UserService userService;

//    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
//    public String addUser(@RequestBody UserModel userModel) {
//        userService.addUserToList(userModel);
//        return "User added successfully";
//    }

    @RequestMapping(value = "/getuser/{username}", method = RequestMethod.GET)
    public UserModel getUser(@PathVariable @NonNull String  username) {
        return userService.getUser(username);
    }

    @RequestMapping(value = "/deleteuser/{username}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable @NonNull String username) {
        userService.deleteUser(username);
        return "User deleted successfully";
    }
//    @RequestMapping(value = "/getallusers", method = RequestMethod.GET)
//    public Collection<UserModel> getAllUsers() {
//       return userService.getUserList();
//    }

    @RequestMapping(value = "/updateuserlocation", method = RequestMethod.POST)
    public String updateLocation(@RequestBody UserModel userModel) {
        userService.updateUserLocation(userModel);
        return "User location updated successfully";
    }
}
