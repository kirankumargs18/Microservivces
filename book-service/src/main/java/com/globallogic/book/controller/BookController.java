package com.globallogic.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.book.dto.BookDto;
import com.globallogic.book.service.BookService;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

	@Autowired
	private BookService bookService;

	/**
	 * Gets all Books
	 */
	@GetMapping
	public ResponseEntity<List<BookDto>> fetchAllBooks() {
		return new ResponseEntity<>(bookService.fetchAllBooks(), HttpStatus.OK);
	}

	/**
	 * saves a Book
	 */
	@PostMapping
	public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto) {

		return new ResponseEntity<BookDto>(bookService.addBook(bookDto), HttpStatus.CREATED);

	}

}
