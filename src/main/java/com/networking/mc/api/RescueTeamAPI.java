package com.networking.mc.api;

import com.networking.mc.api.response.GeneralResponseMessage;
import com.networking.mc.model.NotificationMessages;
import com.networking.mc.model.RescueModel;
import com.networking.mc.model.RescueModelResponse;
import com.networking.mc.service.RescueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/rescuer")
public class RescueTeamAPI {

    @Autowired
    private RescueService rescueService;

    private final Logger logger = LoggerFactory.getLogger(UserAPI.class);

    /**
     * API to sign up the rescuer
     * @param rescueModel
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/signuprescuer", method = RequestMethod.POST)
    public GeneralResponseMessage signUpRescuer(@RequestBody RescueModel rescueModel) {
        logger.info("Request received at " + Instant.now() + "at /signuprescuer api");
        return new GeneralResponseMessage(rescueService.addRescuerToList(rescueModel));
    }

    /**
     * API to login the rescuer
     * @param rescueModel
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/loginrescuer", method = RequestMethod.POST)
    public GeneralResponseMessage loginRescuer(@RequestBody RescueModel rescueModel) {
        logger.info("Request received at " + Instant.now() + "at /loginrescuer api");
        return new GeneralResponseMessage(rescueService.loginRescuer(rescueModel));
    }

    /**
     * API to get all rescuers
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getallrescuers", method = RequestMethod.GET)
    public List<RescueModelResponse> getAllRescuers() {
        logger.info("Request received at " + Instant.now() + "at /getallrescuers api");
        return rescueService.getRescuerList();
    }

    /**
     * To add multiple rescuers
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/addmultiplerescuers", method = RequestMethod.GET)
    public GeneralResponseMessage addMultipleRescuers() {
        rescueService.addMultipleUsers();
        logger.info("Request received at " + Instant.now() + "at /addmultiplerescuers api");
        return new GeneralResponseMessage("Multiple rescuers added to the list");
    }

    /**
     * To clear all the rescuers
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/clearallrescuers", method = RequestMethod.GET)
    public GeneralResponseMessage clearAllRescuers() {
        rescueService.clearAllRescuers();
        logger.info("Request received at " + Instant.now() + "at /clearallrescuers api");
        return new GeneralResponseMessage("Multiple rescuers cleared from the list");
    }

    /**
     * To delete a rescuer
     * @param rescuerName
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/deleterescuer", method = RequestMethod.DELETE)
    public GeneralResponseMessage deleteRescuer(@RequestParam String rescuerName) {
        rescueService.deleteRescuer(rescuerName);
        logger.info("Request received at " + Instant.now() + "at /deleterescuer api");
        return new GeneralResponseMessage("Rescuer Deleted");
    }

    /**
     * To get a rescuer notification
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/getrescuernotification", method = RequestMethod.GET)
    public NotificationMessages getNotification() {
        logger.info("Request received at " + Instant.now() + "at /getrescuernotification api");
        NotificationMessages notificationMessages = new NotificationMessages();
        if(rescueService.getNotification() == null) {
            notificationMessages.notificationMessage = "";
        } else {
            notificationMessages.notificationMessage = rescueService.getNotification();
        }
        return  notificationMessages;
    }

    /**
     * To update recuers status
     * @param status
     * @param rescuerName
     * @return
     */
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/updaterescuerstatus", method = RequestMethod.GET)
    public GeneralResponseMessage updateRescuerStatus(@RequestParam String status, @RequestParam String rescuerName) {
        logger.info("Request received at " + Instant.now() + "at /updaterescuerstatus api");
        return new GeneralResponseMessage(rescueService.updateRescuerStatus(status, rescuerName));
    }
}
