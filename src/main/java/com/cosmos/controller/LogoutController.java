package com.cosmos.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/logout")
public class LogoutController {
    @Value("${okta.oauth2.issuer}")
    private String issuerUrl;

    @Value("${okta.oauth2.post-logout-redirect-uri}")
    private String postLogoutRedirectUri;

    @GetMapping
    public String logout(@AuthenticationPrincipal OidcUser oidcUser) {
        String idToken = oidcUser.getIdToken().getTokenValue();
        String logoutUrl = String.format("%s/v1/logout?id_token_hint=%s&post_logout_redirect_uri=%s",
                issuerUrl, idToken, postLogoutRedirectUri);
        return "redirect:" + logoutUrl;
    }
}
