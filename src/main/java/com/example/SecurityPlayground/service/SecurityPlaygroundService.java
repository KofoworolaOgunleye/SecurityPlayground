package com.example.SecurityPlayground.service;

import com.example.SecurityPlayground.repository.SecurityPlaygroundRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class SecurityPlaygroundService implements OAuth2UserService {
    @Autowired
    SecurityPlaygroundRepository securityPlaygroundRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        DefaultOAuth2UserService defaultOAuthUserService = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = defaultOAuthUserService.loadUser(userRequest);

        String githubUsername = oAuth2User.getAttributes().get("login").toString();
        Long githubUsernameID = Long.getLong(oAuth2User.getAttributes().get("id").toString());

        //User repositoryUser = securityPlaygroundRepository.findByGithubUsername(githubUsername);

        return oAuth2User;
    }

    public String protectedGreeting(OAuth2User principal) {
        String name = principal.getAttributes().get("id").toString();
        String username = principal.getAttributes().get("login").toString();

        return "Hiiiii! Welcome " + username + " " + "(" + name + ")" + "!";
    }
}
