package com.KCG.Online_Shopping_Products;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Online Shopping ProductsApplication API", version = "v1", description = "API documentation for Online Shopping Products Application"))
public class OnlineShoppingProductsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineShoppingProductsApplication.class, args);
	}

}
