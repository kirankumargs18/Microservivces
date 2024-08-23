package com.globallogic.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OrderController {

	@GetMapping("/order-provider")
	public String getOrder() {
		return "This is Order";
	}

}
