package com.example.configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springdoc.core.SpringDocUtils;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ForwardedHeaderFilter;

@Configuration
public class Swagger3Config {
    @Bean
    public OpenAPI docket() {
        return new OpenAPI()
                .components(new Components())
                // info
                .info(new Info().title("Swagger 3 Application API")
                        .description("Sample OpenAPI 3.0")
                        .contact(new Contact()
                                .email("buiducchien241125@gmail.com")
                                .name("chienbd")
                                .url("facebook.com/chien241125"))
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
