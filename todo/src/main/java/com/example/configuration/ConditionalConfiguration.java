package com.example.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnProperty
@Configuration
public class ConditionalConfiguration {
    @Bean
    String makeAString(){
        return "test";
    }
}
