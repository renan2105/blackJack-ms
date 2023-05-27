package com.renan.bjuser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class BjUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(BjUserApplication.class, args);
	}

}
