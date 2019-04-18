package com.example.uidmdemo;

import com.rooxteam.uidm.sdk.spring.configuration.UidmSdkConfiguration;
import com.rooxteam.uidm.sdk.spring.configuration.UidmSpringSecurityFilterConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(UidmSpringSecurityFilterConfiguration.class)
public class UidmDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UidmDemoApplication.class, args);
    }

}
