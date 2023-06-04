package com.example.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.SpringDocUtils;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ForwardedHeaderFilter;

import java.util.Arrays;

@Configuration
public class Swagger3Config {
    @Bean
    public OpenAPI docket() {
        return new OpenAPI()
                .components(new Components())
                // info
                .info(new Info().title("Loda Application API")
                        .description("Sample OpenAPI 3.0")
                        .contact(new Contact()
                                .email("loda.namnh@gmail.com")
                                .name("loda")
                                .url("https://loda.me/"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://www.apache.org/licenses/LICENSE-2.0.html"))
                        .version("1.0.0"));
    }

    static {
        SpringDocUtils.getConfig().addHiddenRestControllers(BasicErrorController.class);
    }
    @Bean
    ForwardedHeaderFilter forwardedHeaderFilter() {
        return new ForwardedHeaderFilter();
    }
}
