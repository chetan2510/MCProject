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
}
