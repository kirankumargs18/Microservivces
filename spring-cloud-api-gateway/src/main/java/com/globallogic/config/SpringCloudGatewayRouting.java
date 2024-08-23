package com.globallogic.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudGatewayRouting {
	
	/*
	 * @Bean public RouteLocator configureRoute(RouteLocatorBuilder builder) {
	 * 
	 * return builder.routes()
	 * .route("paymentId",r->r.path("/payment-service/**").uri(
	 * "http://localhost:9009")) //static routing .route("orderId",r->
	 * r.path("/order-service/**").uri("lb://order-service")) //dynamic routing
	 * .build(); }
	 */
	
	public RouteLocator configureRoutes(RouteLocatorBuilder builder) {
		
		return builder
				.routes()
				
				.route(r-> r.path("/payment-service").uri("lb://paymnet-service"))
				.route(r-> r.path("/order-service").uri("lb://order-service"))
				
				.build();
	}
	
	

}
