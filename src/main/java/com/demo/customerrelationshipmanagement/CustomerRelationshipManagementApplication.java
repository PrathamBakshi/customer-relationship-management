package com.demo.customerrelationshipmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.demo.customerrelationshipmanagement")
public class CustomerRelationshipManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerRelationshipManagementApplication.class, args);
	}

}
