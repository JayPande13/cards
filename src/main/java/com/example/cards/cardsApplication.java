package com.example.cards;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(info = @Info(
		title = "Cards Microservice",
		description = "Microservices for adding cards into accounts",
		contact = @Contact(
				name = "Jay Pande",
				email = "jmaypande@gmail.com",
				url = "https://www.google.com"
		),
		license = @License(
				name = "Apache 2.0",
				url = "https://www.eazybytes.com"
		)
),
		externalDocs = @ExternalDocumentation(
				description = "Cards microservice REST API Documentation",
				url = "http://localhost:9000/swagger-ui.html"
))
public class cardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(cardsApplication.class, args);
	}

}
