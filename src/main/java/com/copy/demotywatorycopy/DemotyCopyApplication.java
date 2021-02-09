package com.copy.demotywatorycopy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableGlobalMethodSecurity(
        prePostEnabled = true,
        securedEnabled = true,
        jsr250Enabled = true)
@SpringBootApplication
public class DemotyCopyApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemotyCopyApplication.class, args);
    }

}
