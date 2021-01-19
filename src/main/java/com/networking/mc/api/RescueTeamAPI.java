package com.networking.mc.api;

import com.networking.mc.api.response.GeneralResponseMessage;
import com.networking.mc.model.RescueModel;
import com.networking.mc.model.UserModel;
import com.networking.mc.service.RescueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
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

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getallrescuers", method = RequestMethod.GET)
    public Collection<RescueModel> getAllRescuers() {
        return rescueService.getRescuerList();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/addmultiplerescuers", method = RequestMethod.GET)
    public GeneralResponseMessage addMultipleRescuers() {
        rescueService.addMultipleUsers();
        return new GeneralResponseMessage("Multiple rescuers added to the list");
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/clearallrescuers", method = RequestMethod.GET)
    public GeneralResponseMessage clearAllRescuers() {
        rescueService.clearAllRescuers();
        return new GeneralResponseMessage("Multiple rescuers cleared from the list");
    }

    @RequestMapping(value = "/getRescuerNotification", method = RequestMethod.GET)
    public String getNotification() {
        return rescueService.notification.equals("") ? "":rescueService.notification;
    }
}
