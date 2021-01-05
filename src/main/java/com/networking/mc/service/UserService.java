package com.networking.mc.service;

import com.networking.mc.Exceptions.Service.UserAlreadyExistsException;
import com.networking.mc.model.UserModel;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.LinkedHashMap;

@Service  // will register it as a service. singleton only one instance will be there.
public class UserService {

    private LinkedHashMap<String , UserModel> userModeMap = new LinkedHashMap<>();

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

    public void deleteUser(UserModel userModel) {
        userModeMap.remove(userModel.userName);
    }

    public UserModel getUser(UserModel userModel) {
        return userModeMap.get(userModel.userName);
    }

    public void updateUserLocation(UserModel userModel) {
        userModeMap.get(userModel.userName).Latitude = userModel.Latitude;
        userModeMap.get(userModel.userName).Latitude = userModel.longitude;
    }
}
