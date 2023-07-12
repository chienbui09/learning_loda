package com.personal.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.mongo")
@Data
public class MongoParams {
    private String host;
    private Integer port;
    private String username;
    private String password;
    @JsonProperty("auth-db")
    private String authDb;
}
