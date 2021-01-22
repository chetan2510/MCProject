package com.networking.mc.api;

import com.networking.mc.api.response.GeneralResponseMessage;
import com.networking.mc.api.response.NotificationMessage;
import com.networking.mc.model.RescueModel;
import com.networking.mc.service.RescueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Collection;
import java.util.LinkedHashMap;

@RestController
@RequestMapping("/rescuer")
public class RescueTeamAPI {

    @Autowired
    private RescueService rescueService;

    private final Logger logger = LoggerFactory.getLogger(UserAPI.class);

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/addrescuer", method = RequestMethod.POST)
    public GeneralResponseMessage addRescuer(@RequestBody RescueModel rescueModel) {
        logger.info("Request received at " + Instant.now() + "at /adrescuer api");
        return new GeneralResponseMessage(rescueService.addRescuerToList(rescueModel));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getallrescuers", method = RequestMethod.GET)
    public Iterable<RescueModel> getAllRescuers() {
        logger.info("Request received at " + Instant.now() + "at /getallrescuers api");
        return rescueService.getRescuerList();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/addmultiplerescuers", method = RequestMethod.GET)
    public GeneralResponseMessage addMultipleRescuers() {
        rescueService.addMultipleUsers();
        logger.info("Request received at " + Instant.now() + "at /addmultiplerescuers api");
        return new GeneralResponseMessage("Multiple rescuers added to the list");
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/clearallrescuers", method = RequestMethod.GET)
    public GeneralResponseMessage clearAllRescuers() {
        rescueService.clearAllRescuers();
        logger.info("Request received at " + Instant.now() + "at /clearallrescuers api");
        return new GeneralResponseMessage("Multiple rescuers cleared from the list");
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/deleterescuer", method = RequestMethod.DELETE)
    public GeneralResponseMessage deleteRescuer(@RequestParam String rescuerName) {
        rescueService.deleteRescuer(rescuerName);
        logger.info("Request received at " + Instant.now() + "at /deleterescuer api");
        return new GeneralResponseMessage("Rescuer Deleted");
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getrescuernotification", method = RequestMethod.GET)
    public LinkedHashMap<String , String> getNotification() {
        logger.info("Request received at " + Instant.now() + "at /getrescuernotification api");
        return rescueService.notificationMap;
    }
}
