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

import com.globallogic.entity.Book;
import com.globallogic.repository.BookRepository;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;

	@GetMapping
	public ResponseEntity<List<Book>> getAllBooks() {

		return new ResponseEntity<List<Book>>(bookRepository.findAll(), HttpStatus.OK);

	}

	@PostMapping
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {

		return new ResponseEntity<Book>(bookRepository.save(book), HttpStatus.CREATED);

	}

}
