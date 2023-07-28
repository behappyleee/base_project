package com.sample.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataApplication {

	// Spring Data Rest allows to rapidly create a REST API to manipulate and query a database by exposing
	// Spring Data Repositories via its @RepositoryRestResource annotation.

	// For the sake of example, we will use a simple domain model composed of Customer and Address entities.

	// A Customer may have one or more Address. (Each Address may or may not have one Customer)
	// This is relationship can be modelled in different variants with JPA's @ManyToOne @OneToMan annotations.

	public static void main(String[] args) {
		SpringApplication.run(DataApplication.class, args);
	}

}
