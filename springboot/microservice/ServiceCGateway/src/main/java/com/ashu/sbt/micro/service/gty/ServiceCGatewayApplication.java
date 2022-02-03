package com.ashu.sbt.micro.service.gty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceCGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCGatewayApplication.class, args);
	}

}
