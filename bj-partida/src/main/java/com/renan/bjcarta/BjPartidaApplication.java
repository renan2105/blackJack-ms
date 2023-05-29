package com.renan.bjcarta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BjPartidaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BjPartidaApplication.class, args);
	}

}
