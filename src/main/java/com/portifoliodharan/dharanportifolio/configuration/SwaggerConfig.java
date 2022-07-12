package com.portifoliodharan.dharanportifolio.configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI springOpenAPI(){
        return new OpenAPI()
                .info(new Info()
                        .title("Portifólio Dharan")
                        .description("My personal portiflio")
                        .version("v0.0.1")
                        .license(new License()
                                .name("Dharan Portifolio")
                                .url("https://dharan.netlify.app/"))
                        .contact(new Contact()
                                .name("Github Dharan")
                                .url("")
                                .email("dharancosta@gmail.com")))
                .externalDocs(new ExternalDocumentation()
                        .description("Projeto Github")
                        .url(""));

    }
}
