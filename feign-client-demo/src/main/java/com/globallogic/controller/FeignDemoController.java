package com.globallogic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.util.FeignServiceUtil;

@RestController
@RequestMapping("/demo")
public class FeignDemoController {

	@Autowired
	private FeignServiceUtil feignServiceUtil;

	@GetMapping("/username")
	public String getUserName() {
		return feignServiceUtil.getName();
	}

	@GetMapping("/useraddress")
	public String getUserAddress() {
		return feignServiceUtil.getAddress();
	}
	
	@GetMapping("/userstatus")
	public String getStatus() {
		return feignServiceUtil.getStatus();
	}

}
