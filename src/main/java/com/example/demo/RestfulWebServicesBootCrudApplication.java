package com.example.demo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class RestfulWebServicesBootCrudApplication {


	private final static String GET_ALL_Employees_API="http://localhost:8080/api/employees";
	
	public static void main(String[] args) {
		SpringApplication.run(RestfulWebServicesBootCrudApplication.class, args);
	}

	
}
