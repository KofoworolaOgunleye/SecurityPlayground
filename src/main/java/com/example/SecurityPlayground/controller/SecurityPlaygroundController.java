package com.example.SecurityPlayground.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SecurityPlaygroundController {

    @GetMapping("/open/greeting")
    public String openGreeting(){
        return "Dear user, welcome!";
    }

    @GetMapping("/protected/greeting")
    public String protectedGreeting(@AuthenticationPrincipal OAuth2User principal){
        String name= principal.getAttributes().get("id").toString();
        String username = principal.getAttributes().get("login").toString();

        return "Hiiiii! Welcome "+ username + " " +"(" +name + ")"+"!";
    }
}
