package io.github.renatovilaca.creditevaluator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CreditevaluatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditevaluatorApplication.class, args);
	}

}
