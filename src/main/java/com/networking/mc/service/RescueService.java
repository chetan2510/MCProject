package com.networking.mc.service;

import com.networking.mc.Exceptions.Service.EmptyStringException;
import com.networking.mc.Exceptions.Service.RescuerDoesNotExistsException;
import com.networking.mc.Exceptions.Service.UserDoesNotExistsException;
import com.networking.mc.model.RescueModel;
import com.networking.mc.model.RescueModelResponse;
import com.networking.mc.repository.RescuerRepository;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

@Service
public class RescueService {

//    private LinkedHashMap<String , RescueModel> rescuerModeMap = new LinkedHashMap<>();

    public LinkedHashMap<String , String> notificationMap  = new LinkedHashMap<>();

    @Autowired
    RescuerRepository rescuerRepository;

    public String addRescuerToList(RescueModel rescueModel) {
            rescuerRepository.save(rescueModel);
            return "Rescuer added to the list, please sign in to continue";
    }

    public String loginRescuer(RescueModel resModel) {
            RescueModel rescueModel = rescuerRepository.findByRescuerName(resModel.rescuerName);
            if(rescueModel.password.equals(resModel.password)) {
                return "Success";
            } else {
                return "Fail";
            }
    }

    public List<RescueModelResponse> getRescuerList() {
        List<RescueModelResponse> responseList = new LinkedList<>();
        Iterable<RescueModel> iterable = rescuerRepository.findAll();
        for(RescueModel rescueModel : iterable) {
            RescueModelResponse rescueModelResponse = new RescueModelResponse(rescueModel.rescuerName, rescueModel.latitude, rescueModel.longitude, rescueModel.status);
            responseList.add(rescueModelResponse);
        }
        return  responseList;
    }

    public void addMultipleUsers(){
        double latitude = 50.1201;
        double longitude = 8.6521;
        for(int num = 1; num <=19; num++) {
            latitude = latitude + 0.2;
            longitude = longitude + 0.2;
            RescueModel rescueModel = new RescueModel("Rescuer" +num, latitude + "", longitude + "", "Active", "qwertyuiop");
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


    public String updateRescuerStatus(String status, String userName) {

        RescueModel rescueModel = rescuerRepository.findByRescuerName(userName);

        if(rescueModel == null) {
            throw new RescuerDoesNotExistsException();
        }

        if(!StringUtil.isNullOrEmpty(status)) {
            rescueModel.status = status;
            rescuerRepository.save(rescueModel);
            return "Status updated successfully";
        } else {
            throw new EmptyStringException();
        }
    }

}
