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

    @NonNull
    public String emergencyType;

    @NonNull
    public String emergencySeverity;

    @NonNull
    public String victimHealthStatus;



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


    /**
     *
     * @param userName
     * @param latitude
     * @param longitude
     * @param emergencyType
     * @param emergencySeverity
     * @param victimHealthStatus
     */
    public UserModel(String userName, String latitude, String longitude, String emergencyType, String emergencySeverity, String victimHealthStatus) {
        this.userName = userName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.emergencySeverity = emergencySeverity;
        this.emergencyType = emergencyType;
        this.victimHealthStatus = victimHealthStatus;
    }

    protected UserModel() {}
}
