package com.casanova.simcard.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SimcardServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimcardServiceApplication.class, args);
	}

}
