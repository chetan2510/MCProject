package com.networking.mc.model;

import com.sun.istack.NotNull;
import lombok.NonNull;

import javax.persistence.Id;

public class RescuerLoginModel {

    @NonNull
    @Id
    public String rescuerName;

    @NotNull
    public String password;
}
