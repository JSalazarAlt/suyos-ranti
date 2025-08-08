package com.suyos.ranti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main application class for the Ranti e-commerce platform.
 * This class serves as the entry point for the Spring Boot application.
 * 
 * @author Suyos Team
 * @version 1.0
 * @since 1.0
 */
@SpringBootApplication
public class RantiApplication {

	/**
	 * Main method to start the Spring Boot application.
	 * 
	 * @param args command line arguments
	 * @since 1.0
	 */
	public static void main(String[] args) {
		SpringApplication.run(RantiApplication.class, args);
	}

}
