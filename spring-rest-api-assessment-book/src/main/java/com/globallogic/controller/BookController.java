/**
 * @author kiran
 * @createdDate 22/11/2022
 * */
package com.globallogic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globallogic.dto.BookDto;
import com.globallogic.service.BookService;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

	@Autowired
	private BookService bookService;

	/**
	 * Gets all books
	 * */
	@GetMapping
	public ResponseEntity<List<BookDto>> getAllBooks() {

		return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
	}

	/**
	 * Saves a book to database
	 * */
	@PostMapping
	public ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto) {

		return new ResponseEntity<BookDto>(bookService.addBook(bookDto), HttpStatus.CREATED);
	}

	/**
	 * Gets book by it's id
	 * */
	@GetMapping("/{bookId}")
	public ResponseEntity<BookDto> getBookById(@PathVariable Long bookId) {

		return new ResponseEntity<BookDto>(bookService.getBookById(bookId), HttpStatus.OK);
	}
	
	/**
	 * Updates a book by it's id
	 * */
	@PutMapping("/{bookId}")
	public ResponseEntity<BookDto> updateBookById(@PathVariable Long bookId, @RequestBody BookDto bookDto){
		
		return new ResponseEntity<BookDto>(bookService.updateBookById(bookId, bookDto), HttpStatus.OK);
	}
	
	/**
	 * Deletes a book by it's id
	 * */
	@DeleteMapping("/{bookId}")
	public ResponseEntity<String> deleteBookById(@PathVariable Long id){
		 
		return new ResponseEntity<String>("Book Deleted Successfully", HttpStatus.OK);
	}

}
