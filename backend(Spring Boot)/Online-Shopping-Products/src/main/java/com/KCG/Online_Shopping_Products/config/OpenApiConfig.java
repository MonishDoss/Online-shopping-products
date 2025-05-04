package com.KCG.Online_Shopping_Products.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Online Shopping API")
                        .version("1.0")
                        .description("API documentation for the online shopping cart system")
                        .contact(new Contact().name("Monish R").url("https://github.com/MonishDoss").email("monishdoss2005@gmail.com")));
    }
}
