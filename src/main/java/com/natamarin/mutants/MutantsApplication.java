package com.natamarin.mutants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MutantsApplication {

	public static String main(String[] args) {
		SpringApplication.run(MutantsApplication.class, args);
		return "Hello World!";
	}

}
