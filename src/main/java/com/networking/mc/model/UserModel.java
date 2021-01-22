package com.networking.mc.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class UserModel {

    @Id
    @NonNull
    public String userName;

    @NonNull
    public String latitude;

    @NonNull
    public String longitude;

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

    protected UserModel() {}
}
