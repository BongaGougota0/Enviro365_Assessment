package com.enviro.assessment.grad001.bongagougota.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class is for documenting the API endpoints.
 * The API documentation can be found at http://localhost:8080/swagger-ui/index.html#/
 */
@Configuration
public class SwaggerConfig {

    @Bean
    GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("api")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Environmental Solutions Company API")
                        .description(" REST endpoints to enable communication between the frontend and backend systems of the\n" +
                                "Enviro365 software systems.")
                        .version("1.0")
                        .contact(new Contact()
                                .name("Bonga Gougota")
                                .email("bonga.gougota@gmail.com")));
    }
}
