package com.example.uidmdemo.systemauth;

import com.rooxteam.sso.clientcredentials.ClientCredentialsClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Controller shows how business logic can access system auth token.
 */
@RestController
@RequestMapping("/api/systemtoken")
public class SystemAuthController {

    final ClientCredentialsClient clientCredentialsClient;

    public SystemAuthController(final ClientCredentialsClient clientCredentialsClient) {
        this.clientCredentialsClient = clientCredentialsClient;
    }


    @GetMapping(value = "@header", produces = "application/json")
    public String getAuthHeader(HttpServletRequest httpServletRequest) {
        return clientCredentialsClient.getAuthHeaderValue();
    }

    @GetMapping(value = "@token", produces = "application/json")
    public String getToken(HttpServletRequest httpServletRequest) {
        return clientCredentialsClient.getToken();
    }
}
