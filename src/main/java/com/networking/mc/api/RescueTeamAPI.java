package com.networking.mc.api;

import com.networking.mc.model.RescueModel;
import com.networking.mc.service.RescueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.LinkedHashMap;

@RestController
@RequestMapping("/rescuer")
public class RescueTeamAPI {

    @Autowired
    private RescueService rescueService;

    @RequestMapping(value = "/addrescuer", method = RequestMethod.POST)
    public String addUser(@RequestBody RescueModel rescueModel) {
        rescueService.addRescuerToList(rescueModel);
        return "Rescuer added successfully";
    }

    @RequestMapping(value = "/getallrescuers", method = RequestMethod.GET)
    public LinkedHashMap<String , RescueModel> getAllRescuers() {
        return rescueService.getRescuerList();
    }

    @RequestMapping(value = "/addmultiplerescuers", method = RequestMethod.GET)
    public String addMultipleRescuers() {
        rescueService.addMultipleUsers();
        return "Multiple rescuers added to the list";
    }

    @RequestMapping(value = "/getRescuerNotification", method = RequestMethod.GET)
    public String getNotification() {
        return rescueService.notification.equals("") ? "":rescueService.notification;
    }
}
