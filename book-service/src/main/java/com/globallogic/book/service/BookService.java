package com.globallogic.book.service;

import java.util.List;

import com.globallogic.book.dto.BookDto;

public interface BookService {
	
	List<BookDto> fetchAllBooks();
	
	BookDto addBook(BookDto bookDto);

}
