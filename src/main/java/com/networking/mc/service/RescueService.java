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

    /**
     * To add rescier to the list
     * @param rescueModel
     * @return
     */
    public String addRescuerToList(RescueModel rescueModel) {
            rescuerRepository.save(rescueModel);
            return "Rescuer added to the list, please sign in to continue";
    }

    /**
     * To login the rescuer
     * @param resModel
     * @return
     */
    public String loginRescuer(RescueModel resModel) {
            RescueModel rescueModel = rescuerRepository.findByRescuerName(resModel.rescuerName);
            if(rescueModel == null){
                throw new RescuerDoesNotExistsException();
            }
            if(rescueModel.password.equals(resModel.password)) {
                return "Success";
            } else {
                return "Fail";
            }
    }

    /**
     * To get the rescuer list
     * @return
     */
    public List<RescueModelResponse> getRescuerList() {
        List<RescueModelResponse> responseList = new LinkedList<>();
        Iterable<RescueModel> iterable = rescuerRepository.findAll();
        for(RescueModel rescueModel : iterable) {
            RescueModelResponse rescueModelResponse = new RescueModelResponse(rescueModel.rescuerName, rescueModel.latitude, rescueModel.longitude, rescueModel.status);
            responseList.add(rescueModelResponse);
        }
        return  responseList;
    }

    /**
     * To add multiple rescuers
     */
    public void addMultipleUsers(){
        double [] latitude = {50.1201, 50.1301, 50.1401,50.1501, 50.1601, 50.1701, 50.1801};
        double [] longitude = {8.6521, 8.6721, 8.6821, 8.6921, 8.7021, 8.7121, 8.7221};

        for(int num = 0; num < 7; num++) {
            RescueModel rescueModel = new RescueModel("Rescuer" +num, latitude[num] + "", longitude[num] + "", "Active", "qwertyuiop");
            addRescuerToList(rescueModel);
        }
    }

    /**
     * To clear all rescuers
     */
    public void clearAllRescuers(){
       rescuerRepository.deleteAll();
    }

    /**
     * To add the notification
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
     * To get the notification
     * @return
     */
    public String getNotification() {
        return this.notificationMap.get("notification");
    }

    /**
     * To delete a rescuer
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


    /**
     * To update rescuer status
     * @param status
     * @param userName
     * @return
     */
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
