package com.networking.mc.service;

import com.networking.mc.Exceptions.Service.UserAlreadyExistsException;
import com.networking.mc.Exceptions.Service.UserDoesNotExistsException;
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
}
