package com.networking.mc.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class RescueModel {

    @NonNull
    @Id
    public String rescuerName;

    @NonNull
    public String latitude;

    @NonNull
    public String longitude;

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

    protected RescueModel() {}
}
