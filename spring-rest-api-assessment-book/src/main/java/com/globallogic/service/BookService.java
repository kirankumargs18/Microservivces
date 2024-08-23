/**
 * @author kiran
 * @createdDate 22/11/2022
 * */
package com.globallogic.service;

import java.util.List;

import com.globallogic.dto.BookDto;

public interface BookService {

	List<BookDto> getAllBooks();

	BookDto addBook(BookDto bookDto);

	BookDto getBookById(Long bookId);

	BookDto updateBookById(Long bookId, BookDto bookDto);

	void deleteBookById(Long id);

}
