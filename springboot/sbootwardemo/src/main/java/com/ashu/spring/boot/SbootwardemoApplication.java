package com.ashu.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SbootwardemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbootwardemoApplication.class, args);
	}
	
	@GetMapping("/greeting")
	String greeting() {
		return "Hello world, I'm so simple aha" ;
	}

}