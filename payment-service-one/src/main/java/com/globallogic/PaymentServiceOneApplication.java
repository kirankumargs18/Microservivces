package com.globallogic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PaymentServiceOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(PaymentServiceOneApplication.class, args);
	}

}
