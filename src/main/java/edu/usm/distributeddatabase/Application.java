package edu.usm.distributeddatabase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * This Application is used as backed api to provide features like,
 * Customer Sign Up
 * Customer Login
 * View the Products Details associated to the category
 */
public class Application{

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
