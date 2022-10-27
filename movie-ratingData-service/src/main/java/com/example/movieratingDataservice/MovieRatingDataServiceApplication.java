package com.example.movieratingDataservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieRatingDataServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieRatingDataServiceApplication.class, args);
	}

}
