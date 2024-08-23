package com.globallogic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class OrderServiceOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceOneApplication.class, args);
	}

}
