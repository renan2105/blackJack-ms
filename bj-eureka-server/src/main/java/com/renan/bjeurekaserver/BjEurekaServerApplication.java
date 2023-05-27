package com.renan.bjeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BjEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BjEurekaServerApplication.class, args);
	}

}
