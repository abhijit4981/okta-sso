package com.cosmos.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/email")
public class HomeController {
    @GetMapping
    public String home(@AuthenticationPrincipal OidcUser oidcUser) {
        RestTemplate restTemplate = new RestTemplate();
        String response = "Login First";
        if (oidcUser != null)
            response = oidcUser.getEmail().toString();
        return response;
    }
}
