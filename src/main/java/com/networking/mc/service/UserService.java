package com.networking.mc.service;

import com.networking.mc.Exceptions.Service.UserDoesNotExistsException;
import com.networking.mc.model.RescueModel;
import com.networking.mc.model.UserModel;
import com.networking.mc.repository.UserRepository;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.LinkedHashMap;

@Service  // will register it as a service. singleton only one instance will be there.
public class UserService {


    @Autowired
    UserRepository userRepository;

//    private LinkedHashMap<String , UserModel> userModeMap = new LinkedHashMap<>();
    public LinkedHashMap<String , String> notificationMap = new LinkedHashMap<>();

    /**
     * To add users to the list
     * @param userModel
     * @return
     */
    public String addUserToList(UserModel userModel) {
        if(userRepository.findByUserName(userModel.userName) == null) {
            userRepository.save(userModel);
            return "User added successfully";
        } else {
            userRepository.save(userModel);
            return "User location updated successfully";
        }
    }

    /**
     * To get user list
     * @return
     */
    public Iterable<UserModel> getUserList() {
        return userRepository.findAll();
    }

    /**
     * To delete a user
     * @param userName
     */
    @Transactional
    public void deleteUser(String userName) {
        if(userRepository.findByUserName(userName) != null) {
//            userModeMap.remove(userName);
            userRepository.deleteByUserName(userName);
        } else {
            throw new UserDoesNotExistsException();
        }
    }

    /**
     * To delete all the users
     */
    public void deleteAll() {
//       this.userModeMap.clear();
       userRepository.deleteAll();
    }

    /**
     * To get a user
     * @param userName
     * @return
     */
    public UserModel getUser(String userName) {

        UserModel userModel = userRepository.findByUserName(userName);
        if (userModel != null) {
            return userModel;
        } else {
            throw new UserDoesNotExistsException() ;
        }
    }

    /**
     * To add multiple users
     */
    public void addMultipleUsers() {
        double [] latitude = {50.1001, 50.0901, 50.0801,50.0701, 50.0601, 50.0501, 50.0301};
        double [] longitude = {8.6521, 8.6721, 8.6821, 8.6921, 8.7021, 8.7121, 8.7221};
        for(int num = 0; num < 7; num++) {
            UserModel userModel = new UserModel("User" +num, latitude[num] + "", longitude[num] + "", "flood", "medium", "normal");
            addUserToList(userModel);
        }
    }

    /**
     * To add notification
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
     * To get a notification
     * @return
     */
    public String getNotification() {
        return this.notificationMap.get("notification");
    }
}
