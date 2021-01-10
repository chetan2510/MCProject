package com.networking.mc.api;

import com.networking.mc.model.UserModel;
import com.networking.mc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping({"/", "/hello"})
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "User";
    }

    @PostMapping(
            path = "/adduser",
            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public String addUser(@RequestParam MultiValueMap<String,String> paramMap, Model model) {
        UserModel userModel = new UserModel();
        userModel.latitude = paramMap.get("latitude").get(0);
        userModel.longitude = paramMap.get("longitude").get(0);
        userModel.userName = paramMap.get("userName").get(0);
        userService.addUserToList(userModel);
        model.addAttribute("message", "User added successfully");
       return "UserAddSuccess";
    }


    @RequestMapping(value = "/getallusers", method = RequestMethod.GET)
    public String getAllUsers(Model model) {
        model.addAttribute("userList", new ArrayList<>(userService.getUserList()));
        return "DisplayUsers";
    }
}
