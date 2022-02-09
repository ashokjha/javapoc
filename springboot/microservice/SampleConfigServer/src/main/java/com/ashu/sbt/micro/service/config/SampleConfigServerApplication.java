package com.ashu.sbt.micro.service.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author Ashok Kumar Jha (ashu.kr.jha@gmail.com)
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class SampleConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleConfigServerApplication.class, args);
	}

}
