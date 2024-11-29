package com.example.SecurityPlayground.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class Greeting {

    @GetMapping("/open/greeting")
    public String openGreeting(){
        return "Dear user, welcome!";
    }

    @GetMapping("/protected/greeting")
    public String protectedGreeting(){
        return "Hiiiii!, Welcome friend!";
    }

}
