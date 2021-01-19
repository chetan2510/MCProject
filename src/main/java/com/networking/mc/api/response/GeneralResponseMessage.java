package com.networking.mc.api.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GeneralResponseMessage {
    String message;

    public GeneralResponseMessage(String message) {
        this.message = message;
    }
}
