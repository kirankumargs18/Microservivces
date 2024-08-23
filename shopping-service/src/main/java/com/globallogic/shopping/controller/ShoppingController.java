package com.globallogic.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class ShoppingController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/shopping-payment/{price}")
	public String invokePaymentService(@PathVariable Integer price) {

		// String url = "http://localhost:8762/payment-provider/payNow/" + price;
		String url = "http://payment-service/payment-provider/payNow/" + price;

		return restTemplate.getForObject(url, String.class);

	}
	
	@GetMapping("/order")
	public String invokeOrderService() {
		String url="http://order-service/order-provider";
		return restTemplate.getForObject(url, String.class);
	}

}
