package com.example.SecurityPlayground.controller;

import com.example.SecurityPlayground.service.SecurityPlaygroundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class SecurityPlaygroundController {

    @Autowired
    SecurityPlaygroundService securityPlaygroundService;

    @GetMapping("/open/greeting")
    public String openGreeting(){
        return "Dear user, welcome!";
    }

//    @GetMapping("/protected/greeting")
//    public String protectedGreeting(@AuthenticationPrincipal OAuth2User principal){
//
//        return securityPlaygroundService.protectedGreeting(principal);
//    }

    @GetMapping("/protected/greeting")
    public String protectedGreeting(OAuth2UserRequest request){

        return securityPlaygroundService.loadUser(request).getAttributes().toString();
    }
}
