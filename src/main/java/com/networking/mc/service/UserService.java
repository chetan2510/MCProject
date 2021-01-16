package com.networking.mc.service;

import com.networking.mc.Exceptions.Service.UserAlreadyExistsException;
import com.networking.mc.Exceptions.Service.UserDoesNotExistsException;
import com.networking.mc.model.UserModel;
import io.netty.util.internal.StringUtil;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashMap;

@Service  // will register it as a service. singleton only one instance will be there.
public class UserService {

    private LinkedHashMap<String , UserModel> userModeMap = new LinkedHashMap<>();
    public String notification = "";

    public void addUserToList(UserModel userModel) {
        if(userModeMap.get(userModel.userName) == null) {
            userModeMap.put(userModel.userName, userModel);
        } else {
            throw new UserAlreadyExistsException();
        }
    }

    public Collection<UserModel> getUserList() {
        return userModeMap.values();
    }

    public void deleteUser(String userName) {
        if(userModeMap.get(userName) != null) {
            userModeMap.remove(userName);
        }
        else {
            throw new UserDoesNotExistsException();
        }
    }

    public UserModel getUser(String userName) {

        if (userModeMap.get(userName) != null) {
            return userModeMap.get(userName);
        } else {
            throw new UserDoesNotExistsException() ;
        }
    }

    public void updateUserLocation(UserModel userModel) {
        if(userModeMap.get(userModel.userName) != null) {
            userModeMap.put(userModel.userName, userModel);
        } else {
            throw new UserDoesNotExistsException();
        }
    }

    public void addMultipleUsers() {

        for(int num = 1; num <=19; num++) {
            UserModel userModel = new UserModel("User" +num, "1"+num, "1"+num);
            addUserToList(userModel);
        }
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
}
