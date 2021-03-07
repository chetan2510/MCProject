package com.networking.mc.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Model class for rescuer
 */
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

    @NotNull
    public String status;

    @NotNull
    @ToString.Exclude()
    public String password;


    /**
     * Constructor
     * @param rescuerName
     * @param latitude
     * @param longitude
     */
    public RescueModel(String rescuerName, String latitude, String longitude, String status, String password) {
        this.rescuerName = rescuerName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
        this.password = password;
    }

    protected RescueModel() {}
}
