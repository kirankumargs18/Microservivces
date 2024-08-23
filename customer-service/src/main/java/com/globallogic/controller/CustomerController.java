package com.globallogic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class CustomerController {
	
	@GetMapping("/service")
	public String getServiceName() {
		return "This is Customer Service";
	}

}
