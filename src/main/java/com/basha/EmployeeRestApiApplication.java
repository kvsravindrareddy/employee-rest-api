package com.basha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the main class which is to bootstrap the Spring Boot application by providing the
 * autoconfiguration and component scan features by default
 */
@SpringBootApplication
public class EmployeeRestApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(EmployeeRestApiApplication.class, args);
	}
}