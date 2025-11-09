package com.hairtherapy.hairtherapy.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI hairTherapyOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Hair Therapy API Documentation")
                        .description("API for managing users, appointments, and blogs for the Hair Therapy system.")
                        .version("1.0.0"));
    }
}
