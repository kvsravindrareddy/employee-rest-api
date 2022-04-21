package com.basha.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class is used to get the API documentation for the Rest endpoints
 */
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI openApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employee")
                        .description("Employee Rest API")
                        .version("v1.0")
                        .contact(new Contact()
                                .name("Shaik Khasim Basha")
                                .url("www.infosys.com")
                                .email("shaikkhasimbasha@gmail.com"))
                        .license(new License().name("License").url("#"))
                );
    }
}
