package com.example.springrocking.actuator.custom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomConfiguration {
    @Bean
    public CustomDataEndpoint CustomDataEndpoint() {
        return new CustomDataEndpoint();
    }
}
