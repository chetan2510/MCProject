package com.networking.mc.messaging.controller;

import com.networking.mc.messaging.pojo.Greeting;
import com.networking.mc.messaging.pojo.HelloMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

@RestController
public class GreetingController {

    @MessageMapping("/resume")
    @SendTo("/start/initial")
    public Greeting greeting(String message) throws Exception {
//        Thread.sleep(1000);
        System.out.println(message);
        Greeting greeting = new Greeting(message);
        return greeting;
        // html escape converts the special character to html syntax
        //return new Greeting("Hello, " + HtmlUtils.htmlEscape(helloMessage.getName()));
    }
}
