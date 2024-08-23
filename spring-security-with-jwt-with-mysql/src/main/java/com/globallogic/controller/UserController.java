package com.globallogic.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Controller to check user roles")
@RestController
@RequestMapping("/api/v1")
public class UserController {
	
	@ApiOperation(value = "Welcomes users to application")
	@PreAuthorize("hasRole('ROLE_SELLER') or hasRole('ROLE_BUYER')")
	@GetMapping("/hello")
	public String hello() {
		return "AnyOne can access this";
	}
	
	@ApiOperation(value = "Can be accessed by seller")
	@PreAuthorize("hasRole('ROLE_SELLER')")
	@PostMapping("/seller")
	public String sellerAccess() {
		return "Only Seller can view this";
	}
	
	@ApiOperation(value = "Can be accessed by buyer")
	@PreAuthorize("hasRole('ROLE_BUYER')")
	@PostMapping("/buyer")
	public String buyerAccess() {
		return "Only buyer can view this";
	}

}
