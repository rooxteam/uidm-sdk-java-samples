package com.example.uidmdemo.controllers;

import com.rooxteam.uidm.sdk.spring.authentication.AuthenticationState;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/api/tokens")
public class TokenIntrospectionController {

    @GetMapping(value = "/@current", produces = "application/json")
    public Authentication get(HttpServletRequest httpServletRequest, Authentication authentication) {

        if (authentication == null) {
            return null;
        }
        // if you are not interested in details you can take just principal
        // code works for any underlying security provider
        String principal = authentication.getName();

        // or use plain servlet API
        httpServletRequest.getUserPrincipal().getName();

        // getRemoteUser also works
        httpServletRequest.getRemoteUser();

        // also you can cast Servlet API principal to UIDM Auth State
        ((AuthenticationState) httpServletRequest.getUserPrincipal()).getUserAuthentication();

        // you can check ROLEs using servlet API also
        // ROLE_CUSTOMER is given by default to any authenticated user that has profile in UIDM
        httpServletRequest.isUserInRole("ROLE_CUSTOMER");

        // and ROLE_SYSTEM is given only when system auth is used
        httpServletRequest.isUserInRole("ROLE_SYSTEM");



        if (authentication instanceof AuthenticationState) {

            // get token attributes, also known as "claims"
            Map<String, Object> attributes = ((AuthenticationState) authentication).getAttributes();

            // telephoneNumber
            attributes.get("telephoneNumber");

            // given name
            attributes.get("givenname");

            // surname
            attributes.get("sn");

            // get auth level - concept for easy access management: from 0 (anonymous) to 10 (OTP passed)
            // 5 - is plain user/password auth
            ((AuthenticationState) authentication).getAuthLevel();

            // get credentials used for authentication of this request - access token in our case
            ((AuthenticationState) authentication).getCredentials();

            // get system authentication - if some system invoked WebAPI from itself
            // is null when user authenticates itself
            Authentication systemAuthentication = ((AuthenticationState) authentication).getSystemAuthentication();

            return authentication;
        } else {
            // authenticated by other means than UIDM
            return null;
        }
    }
}
