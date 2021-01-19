package com.networking.mc.service;

import com.networking.mc.Exceptions.Service.RescuerAlreadyExistsException;
import com.networking.mc.Exceptions.Service.RescuerDoesNotExistsException;
import com.networking.mc.Exceptions.Service.UserDoesNotExistsException;
import com.networking.mc.model.RescueModel;
import io.netty.util.internal.StringUtil;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashMap;

@Service
public class RescueService {

    private LinkedHashMap<String , RescueModel> rescuerModeMap = new LinkedHashMap<>();

    public String notification = "";

    public void addRescuerToList(RescueModel rescueModel) {
        if(rescuerModeMap.get(rescueModel.rescuerName) == null) {
            rescuerModeMap.put(rescueModel.rescuerName, rescueModel);
        } else {
            throw new RescuerAlreadyExistsException();
        }
    }

    public Collection<RescueModel> getRescuerList() {
        return rescuerModeMap.values();
    }

    public void addMultipleUsers(){
        for(int num = 1; num <=19; num++) {
            RescueModel rescueModel = new RescueModel("Rescuer" +num, "1"+num, "1"+num);
            addRescuerToList(rescueModel);
        }
    }

    public void clearAllRescuers(){
       this.rescuerModeMap.clear();
    }

    /**
     *
     * @param notification
     */
    public void addNotification(String notification) {

        if(StringUtil.isNullOrEmpty(notification) || "empty".equals(notification)) {
            this.notification = "";
        } else {
            this.notification = notification;
        }
    }

    /**
     *
     * @param rescuerName
     */
    public void deleteRescuer(String rescuerName) {
        if(rescuerModeMap.get(rescuerName) != null) {
            rescuerModeMap.remove(rescuerName);
        }
        else {
            throw new RescuerDoesNotExistsException();
        }
    }

}
