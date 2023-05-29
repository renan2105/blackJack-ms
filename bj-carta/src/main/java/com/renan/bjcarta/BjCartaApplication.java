package com.renan.bjcarta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BjCartaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BjCartaApplication.class, args);
	}

}
