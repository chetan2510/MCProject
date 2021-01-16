package com.networking.mc.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class UserModel {
    @NonNull
    public String userName;

    @NonNull
    public String latitude;

    @NonNull
    public String longitude;

    public boolean isNotificationSent;
    /**
     * Constructor
     * @param userName
     * @param latitude
     * @param longitude
     */
    public UserModel(String userName, String latitude, String longitude) {
        this.userName = userName;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
