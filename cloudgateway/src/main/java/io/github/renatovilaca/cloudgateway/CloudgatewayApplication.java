package io.github.renatovilaca.cloudgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudgatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(CloudgatewayApplication.class, args);
	}

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder){
		//Routers for discovery server
		return builder
				.routes()
					.route(r -> r.path("/clients/**").uri("lb://client-microservice")) //redirect to the load balacing
					.route(r -> r.path("/creditcards/**").uri("lb://creditcard-microservice"))
				.build();
	}

}
