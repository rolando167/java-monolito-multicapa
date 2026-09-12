package com.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.curso")
@EnableJpaRepositories(basePackages = "com.curso.repository")
@EntityScan(basePackages = "com.curso.model.entity")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}