package com.xxwelldone.workshopmongo.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI swaggerOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Projeto MongoDB + REST API")
                        .description("Revisando conceitos de MongoDB com integração ao Springboot")
                        .version("v0.0.1")
                        .license(new License()
                                .name("Wesley Menezes")
                                .url("https://www.linkedin.com/in/wesley-menezes-625998193/"))
                        .contact(new Contact()
                                .name("")
                                .email("")))
                .externalDocs(new ExternalDocumentation()
                        .description("Github")
                        .url("https://github.com/xxwelldone"));
    }
}