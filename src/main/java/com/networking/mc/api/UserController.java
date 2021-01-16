//package com.networking.mc.api;
//
//import com.networking.mc.model.UserModel;
//import com.networking.mc.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.Collection;
//
//@Controller
//@EnableAutoConfiguration
//public class UserController {
//
//    @Autowired
//    private UserService userService;
//
//    @RequestMapping(value="/getuserform", method = RequestMethod.GET)
//    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
//        model.addAttribute("name", name);
//        return "User";
//    }
//
//    @PostMapping(
//            path = "/adduser",
//            consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
//    public String addUser(@RequestParam MultiValueMap<String,String> paramMap, Model model) {
//        UserModel userModel = new UserModel(paramMap.get("userName").get(0), paramMap.get("latitude").get(0), paramMap.get("longitude").get(0));
//        userService.addUserToList(userModel);
//        model.addAttribute("message", "User added successfully");
//       return "UserAddSuccess";
//    }
//
//
//    @RequestMapping(value = "/getallusers", method = RequestMethod.GET)
//    public Collection<UserModel> getAllUsers(Model model) {
//
//        Collection<UserModel> userList = userService.getUserList();
//        if(userList.isEmpty()) {
//            model.addAttribute("message", "User list is emply, please add users first");
//            return userList;
//        } else {
//            model.addAttribute("userList", new ArrayList<>(userService.getUserList()));
//            if(!userService.notification.equals("empty")) {
//                model.addAttribute("notification", userService.notification);
//            }
//            return userList;
//        }
//
//    }
//
//    @RequestMapping(value="/addmultipleusers", method = RequestMethod.GET)
//    public String addMultipleUsers(Model model) {
//            userService.addMultipleUsers();
//            model.addAttribute("message", "Multiple users added to the list");
//            return "MultipleUsers";
//    }
//}