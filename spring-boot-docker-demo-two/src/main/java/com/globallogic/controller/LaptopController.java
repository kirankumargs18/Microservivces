package com.globallogic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.entity.Laptop;
import com.globallogic.repository.LaptopRepository;

@RestController
@RequestMapping("/api/v/laptops")
public class LaptopController {

	@Autowired
	private LaptopRepository laptopRepository;

	@GetMapping
	public ResponseEntity<List<Laptop>> getAllLaptops() {

		return new ResponseEntity<List<Laptop>>(laptopRepository.findAll(), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Laptop> addLaptop(@RequestBody Laptop laptop) {

		return new ResponseEntity<Laptop>(laptopRepository.save(laptop), HttpStatus.CREATED);
	}

}
