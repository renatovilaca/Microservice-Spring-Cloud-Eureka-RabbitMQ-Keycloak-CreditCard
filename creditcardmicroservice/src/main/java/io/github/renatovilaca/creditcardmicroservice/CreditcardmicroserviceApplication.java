package io.github.renatovilaca.creditcardmicroservice;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableRabbit
public class CreditcardmicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditcardmicroserviceApplication.class, args);
	}

}
