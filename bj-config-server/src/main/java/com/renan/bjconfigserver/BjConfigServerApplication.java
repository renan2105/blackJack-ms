package com.renan.bjconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class BjConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BjConfigServerApplication.class, args);
	}

}
