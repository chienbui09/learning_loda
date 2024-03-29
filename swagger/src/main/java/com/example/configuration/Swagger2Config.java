package com.example.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket docket(){
        final Contact contact = new Contact(
                "Bui Duc Chien",
                null,
                "buiducchien241125@gmail.com"
        );
        final ApiInfo apiInfo = new ApiInfo(
                "Application",
                "demo",
                "1.0.0",
                "git-link",
                contact,
                "null",
                "null",
                Collections.emptyList()
        );
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo);
    }
}
