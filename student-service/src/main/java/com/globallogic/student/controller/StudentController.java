package com.globallogic.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.student.dto.BookDto;
import com.globallogic.student.feignclient.BookServiceFeignClient;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

	@Autowired
	private BookServiceFeignClient bookServiceFeignClient;

	@GetMapping("/showbooks")
	public ResponseEntity<List<BookDto>> showAllBooks() {

		return bookServiceFeignClient.fetchAllBooks();
	}

}
