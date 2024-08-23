package com.globallogic.insuranceclient.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class ClientController {

	@Autowired
	private RestTemplate restTemplate;

	@Value("${insurance.message}")
	private String message;

	@Value("${insurance.provider.url}")
	private String url;

	@GetMapping("/getPlan")
	public List<String> getPlans() {

		List<String> plans = restTemplate.getForObject(url, List.class);
		return plans;
	}

	@GetMapping("/getMessage")
	public String getMessage() {
		
		return message;
	}

}
