package com.cosmos.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class ProfileController {
    @GetMapping("/profile")
    @PreAuthorize("hasAuthority('SCOPE_email')")
    String userDetails(OAuth2AuthenticationToken authentication) {
        return Collections.singletonMap("details", authentication.getPrincipal().getAttributes()).toString();
    }
}
