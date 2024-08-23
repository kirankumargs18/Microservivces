package com.globallogic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/test-service")
public class TestController {

	@GetMapping("/hello")
	public String sayHi() {

		return "Hey, How are you?";
	}

}
