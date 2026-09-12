package com.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.curso")
@EnableJpaRepositories(basePackages = "com.curso") // Cambiado de "com.curso.repository" a "com.curso"
@EntityScan(basePackages = "com.curso") // Cambiado de "com.curso.model.entity" a "com.curso"
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}