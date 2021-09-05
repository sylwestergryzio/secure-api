package com.kainos.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

    public ClientController(OAuth2AuthorizedClientService clientService) {
        // There will be an OAuth2AuthorizedClientService automatically
        // configured as a bean in the Spring application context,
        // so you’ll only need to inject it into wherever you’ll use it.
        this.clientService = clientService;
    }

    private OAuth2AuthorizedClientService clientService;

    @GetMapping("/user")
    String GetCurrentUser() {
        var authenticationToken = getCurrentAuthenticationToken();
        var attributes = authenticationToken.getPrincipal().getAttributes();
        return String.format("nick: %s, email: %s",
            attributes.get("nickname"), attributes.get("email"));
    }

    @GetMapping("/token")
    String GetToken() {
        var authenticationToken = getCurrentAuthenticationToken();

        OAuth2AuthorizedClient client =
            clientService.loadAuthorizedClient(
                authenticationToken.getAuthorizedClientRegistrationId(),
                authenticationToken.getName());

        String accessToken = client.getAccessToken().getTokenValue();

        return accessToken;
    }

    private OAuth2AuthenticationToken getCurrentAuthenticationToken() {
        Authentication authentication =
            SecurityContextHolder
                .getContext()
                .getAuthentication();

        return (OAuth2AuthenticationToken) authentication;
    }
}
