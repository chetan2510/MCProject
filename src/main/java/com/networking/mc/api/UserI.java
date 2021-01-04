package com.networking.mc.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // Marks this class that it has controllers inside it
public class UserI {

    @RequestMapping("/adduser")
    public String addUser() {

        return "User added successfully";
    }
}
