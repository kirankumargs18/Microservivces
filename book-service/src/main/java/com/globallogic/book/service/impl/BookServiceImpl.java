package com.globallogic.book.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.book.dto.BookDto;
import com.globallogic.book.entity.Book;
import com.globallogic.book.repository.BookRepository;
import com.globallogic.book.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	/**
	 * Returns list of Books
	 */
	@Override
	public List<BookDto> fetchAllBooks() {

		return bookRepository.findAll().stream().map(this::convertToDto).collect(Collectors.toList());

	}

	/**
	 * Saves a Book to DB
	 */
	@Override
	public BookDto addBook(BookDto bookDto) {

		return convertToDto(bookRepository.save(convertToEntity(bookDto)));
	}

	/**
	 * Converts Entity to DTO
	 */
	private BookDto convertToDto(Book book) {

		return new ModelMapper().map(book, BookDto.class);

	}

	/**
	 * Converts Entity to DTO
	 */
	private Book convertToEntity(BookDto bookDto) {
		return new ModelMapper().map(bookDto, Book.class);
	}

}
