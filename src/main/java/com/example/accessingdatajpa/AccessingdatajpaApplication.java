package com.example.accessingdatajpa;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccessingdatajpaApplication {
    private static final Logger log = LoggerFactory.getLogger(AccessingdatajpaApplication.class);

    public static void main(String[] args) {
	SpringApplication.run(AccessingdatajpaApplication.class, args);
    }

    @Bean
    public CommandLineRunner demo(CustomerRepository repository) {
	return (args) -> {
	    // Get all customers from CUSTOMER table.
	    var allCustomers = new ArrayList<>();
	    repository.findAll().forEach(allCustomers::add);

	    // Populate CUSTOMER table if empty.
	    if (allCustomers.isEmpty()) {
		repository.save(new Customer("Jack", "Bauer"));
		repository.save(new Customer("Chloe", "O'Brian"));
		repository.save(new Customer("Kim", "Bauer"));
		repository.save(new Customer("David", "Palmer"));
		repository.save(new Customer("Michelle", "Dessler"));
	    }

	    // Re-populate allCustomers.
	    allCustomers = new ArrayList<>();
	    repository.findAll().forEach(allCustomers::add);

	    // Log customers.
	    log.info("Customers found with findAll():");
	    log.info("-------------------------------");
	    allCustomers.forEach(customer -> {
		log.info(customer.toString());
	    });
	    log.info("");

	    // Fetch an individual customer by ID.
	    Customer customer = repository.findById(1L);
	    log.info("Customer found with findById(1L):");
	    log.info("--------------------------------");
	    log.info(customer != null ? customer.toString() : "not found");
	    log.info("");

	    // fetch customers by last name
	    log.info("Customer found with findByLastName('Bauer'):");
	    log.info("--------------------------------------------");
	    repository.findByLastName("Bauer").forEach(bauer -> {
		log.info(bauer != null ? bauer.toString() : "not found");
	    });
	    log.info("");
	};
    }

}
