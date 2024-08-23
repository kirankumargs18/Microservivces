package com.globallogic.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TestController {
	
	Log log=LogFactory.getLog(TestController.class);
	
	@GetMapping("/message")
	public String getMessage() {
		
		log.error("Error Info");
		log.info("Info");
		log.warn("Warning");
		return "This is Message";
	}

}
