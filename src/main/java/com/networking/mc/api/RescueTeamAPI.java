package com.networking.mc.api;

import com.networking.mc.api.response.GeneralResponseMessage;
import com.networking.mc.api.response.NotificationMessage;
import com.networking.mc.model.RescueModel;
import com.networking.mc.service.RescueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/rescuer")
public class RescueTeamAPI {

    @Autowired
    private RescueService rescueService;

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/addrescuer", method = RequestMethod.POST)
    public GeneralResponseMessage addUser(@RequestBody RescueModel rescueModel) {
        rescueService.addRescuerToList(rescueModel);
        return new GeneralResponseMessage("Rescuer added successfully");
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

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/deleterescuer", method = RequestMethod.DELETE)
    public GeneralResponseMessage deleteRescuer(@RequestParam String rescuerName) {
        rescueService.deleteRescuer(rescuerName);
        return new GeneralResponseMessage("Rescuer Deleted");
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getrescuernotification", method = RequestMethod.GET)
    public NotificationMessage getNotification() {
        NotificationMessage notificationMessage = new NotificationMessage("");
        if(rescueService.notification.equals("")) {
            return  notificationMessage;
        } else {
            notificationMessage.notificationMessage=rescueService.notification;
            return  notificationMessage;
        }
    }
}
