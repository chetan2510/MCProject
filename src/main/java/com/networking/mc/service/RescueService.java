package com.networking.mc.service;

import com.networking.mc.Exceptions.Service.RescuerAlreadyExistsException;
import com.networking.mc.Exceptions.Service.RescuerDoesNotExistsException;
import com.networking.mc.Exceptions.Service.UserDoesNotExistsException;
import com.networking.mc.model.RescueModel;
import com.networking.mc.repository.RescuerRepository;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.LinkedHashMap;

@Service
public class RescueService {

//    private LinkedHashMap<String , RescueModel> rescuerModeMap = new LinkedHashMap<>();

    public LinkedHashMap<String , String> notificationMap  = new LinkedHashMap<>();

    @Autowired
    RescuerRepository rescuerRepository;

    public String addRescuerToList(RescueModel rescueModel) {
        if(rescuerRepository.findByRescuerName(rescueModel.rescuerName) == null) {
            rescuerRepository.save(rescueModel);
            return "Rescuer added to the list";
        } else {
            rescuerRepository.save(rescueModel);
            return "Rescuer location updated in the list";
        }
    }

    public Iterable<RescueModel> getRescuerList() {
        return rescuerRepository.findAll();
    }

    public void addMultipleUsers(){
        for(int num = 1; num <=19; num++) {
            RescueModel rescueModel = new RescueModel("Rescuer" +num, "1"+num, "1"+num);
            addRescuerToList(rescueModel);
        }
    }

    public void clearAllRescuers(){
       rescuerRepository.deleteAll();
    }

    /**
     *
     * @param notification
     */
    public void addNotification(String notification) {
        if(StringUtil.isNullOrEmpty(notification) || "empty".equals(notification)) {
            this.notificationMap.put("notification", "");
        } else {
            this.notificationMap.put("notification", notification);
        }
    }

    /**
     *
     * @param rescuerName
     */
    @Transactional
    public void deleteRescuer(String rescuerName) {
        if(rescuerRepository.findByRescuerName(rescuerName) != null) {
//            userModeMap.remove(userName);
            rescuerRepository.deleteByRescuerName(rescuerName);
        } else {
            throw new UserDoesNotExistsException();
        }
    }

}
