package com.networking.mc.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MultipleuserAddedresponse {

    String message;

    public MultipleuserAddedresponse(String message) {
        this.message = message;
    }
}
