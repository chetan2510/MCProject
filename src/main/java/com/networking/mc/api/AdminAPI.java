package com.networking.mc.api;

import com.networking.mc.model.RescueModel;
import com.networking.mc.model.UserModel;
import com.networking.mc.service.AdminService;
import com.networking.mc.service.RescueService;
import com.networking.mc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminAPI {

    @Autowired
    AdminService adminService;

    @Autowired
    UserService userService;

    @Autowired
    RescueService rescueService;

    /**
     * TODO: Try to use mqtt if possible
     *
     * @param notification
     * @return
     */
    @RequestMapping(value="/sendNotificationToUsers", method = RequestMethod.POST)
    public String sendNotificationToUser(@RequestParam String notification) {
        adminService.sendNotificationToUsers(notification);
        return "Notification sent to users";
    }

    /**
     * TODO: Try to use mqtt if possible
     *
     * @param notification
     * @return
     */
    @RequestMapping(value="/sendNotificationToRescuers", method = RequestMethod.POST)
    public String sendNotificationToRescuer(@RequestParam String notification) {
        adminService.sendNotificationToRescuers(notification);
        return "Notification sent to users";
    }

    @RequestMapping(value="/deleteuser", method = RequestMethod.POST)
    public String deleteUser(@RequestParam String userName) {
        userService.deleteUser(userName);
        return "User Deleted";
    }

    @RequestMapping(value="/deleterescuer", method = RequestMethod.POST)
    public String deleteRescuer(@RequestParam String rescuerName) {
        rescueService.deleteRescuer(rescuerName);
        return "Rescuer Deleted";
    }

    @RequestMapping(value = "/adduser", method = RequestMethod.POST)
    public String addUser(@RequestBody UserModel userModel) {
        userService.addUserToList(userModel);
        return "User added successfully";
    }

    @RequestMapping(value = "/addRescuer", method = RequestMethod.POST)
    public String addRescuer(@RequestBody RescueModel rescueModel) {
        rescueService.addRescuerToList(rescueModel);
        return "Rescuer added successfully";
    }

}
