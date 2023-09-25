package com.example.demo.infra.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {

	@Bean
	public OpenAPI openAPI() {
		Contact contact = new Contact();
		contact.setEmail("demo@lab.example.com");
		contact.setName("Demo Corp");
		contact.setUrl("https://lab.exmaple.com");
		Info info = new Info()
				.title("Demo APIs")
				.version("1.0")
				.description("Some APIs for demo use ...");
		return new OpenAPI().info(info);

	}
}
