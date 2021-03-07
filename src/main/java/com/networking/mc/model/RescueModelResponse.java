package com.networking.mc.model;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.persistence.Id;


/**
 * Model class for rescuer response
 */
@Getter
@Setter
public class RescueModelResponse {

    @NonNull
    @Id
    public String rescuerName;

    @NonNull
    public String latitude;

    @NonNull
    public String longitude;

    @NotNull
    private String status;

    public RescueModelResponse(@NonNull String rescuerName, @NonNull String latitude, @NonNull String longitude, String status) {
        this.rescuerName = rescuerName;
        this.latitude = latitude;
        this.longitude = longitude;
        this.status = status;
    }
}
