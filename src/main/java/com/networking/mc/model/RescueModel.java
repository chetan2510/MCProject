package com.networking.mc.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class RescueModel {

    @NonNull
    public String rescuerName;

    @NonNull
    public String latitude;

    @NonNull
    public String longitude;

    public boolean isNotificationSent;

    /**
     * Constructor
     * @param rescuerName
     * @param latitude
     * @param longitude
     */
    public RescueModel(String rescuerName, String latitude, String longitude) {
        this.rescuerName = rescuerName;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
