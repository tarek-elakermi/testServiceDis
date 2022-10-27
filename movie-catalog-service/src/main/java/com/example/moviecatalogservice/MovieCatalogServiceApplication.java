package com.example.moviecatalogservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard
public class MovieCatalogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		HttpComponentsClientHttpRequestFactory
				clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(3000);
		return new RestTemplate(clientHttpRequestFactory);
	}

}

// the solution for microservice "fault Tolerance" here is using Timeout, but
//it doesn't solve the problem completely but partly
	/*HttpComponentsClientHttpRequestFactory
			clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(3000);
				return new RestTemplate(clientHttpRequestFactory);*/


//the best solution now is :
//1- detect something is wrong.
//2- take temporary steps to avoid the situation getting worse.
//3- deactivate the problem component so that it doesn't affect
// downstream components.
//=> which called Circuit breaker pattern.
// |-When does the circuit trip(t9os el call)?
//* Last n requests to consider for decision.
//* How many of those should fail?
//* Timeout duration(how many second to say that a service is a failure).
// ||- When does the circuit un-trip(traja3 el call)?
//* How long after a circuit trip to try again?
