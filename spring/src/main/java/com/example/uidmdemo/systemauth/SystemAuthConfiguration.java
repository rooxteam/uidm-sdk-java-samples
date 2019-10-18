package com.example.uidmdemo.systemauth;

import com.rooxteam.sso.clientcredentials.ClientCredentialsClient;
import com.rooxteam.sso.clientcredentials.ClientCredentialsClientFactory;
import com.rooxteam.sso.clientcredentials.configuration.SpringEnvironmentRooXUidmOpinionatedConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class SystemAuthConfiguration {

    /**
     * Instantiate system token client from spring environment using the same properties as other samples (see README.md)
     * @param environment
     * @return
     */
    @Bean
    public ClientCredentialsClient clientCredentialsClient(Environment environment){
        return ClientCredentialsClientFactory.create(
                new SpringEnvironmentRooXUidmOpinionatedConfiguration(environment)
        );
    }
}
