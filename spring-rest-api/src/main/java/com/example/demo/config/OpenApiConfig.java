package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
			.info(new Info()
				.title("My Application Test Spring Boot 3")
				.version("v1")
				.description("some descrption")
				.termsOfService("http://localhost:8080")
				.license(new License().name("Apache 2.0")
				.url("http://localhost:8080")));
}
		
}
//	
//
