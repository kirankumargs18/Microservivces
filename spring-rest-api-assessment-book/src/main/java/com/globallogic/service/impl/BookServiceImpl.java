/**
 * @author kiran
 * @createdDate 22/11/2022
 * */
package com.globallogic.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.dto.BookDto;
import com.globallogic.entity.Book;
import com.globallogic.exception.BookNotFoundException;
import com.globallogic.repository.BookRepository;
import com.globallogic.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

	@Autowired
	private BookRepository bookRepository;

	/**
	 * @description : Gets All Books from database
	 * @return List<BookDto> : returns list of BookDTOs
	 * */
	@Override
	public List<BookDto> getAllBooks() {

		logger.info("Retrieving all Books........");
		return bookRepository.findAll().stream().map(book -> entityToDto(book)).collect(Collectors.toList());

	}

	/**
	 * @description : Gets All Books from database
	 * @param BookDto : Takes BookDto as parameter
	 * @return BookDto : returns a BookDto
	 * */
	@Override
	public BookDto addBook(BookDto bookDto) {

		logger.info("Saving Book to database........");
		return entityToDto(bookRepository.save(dtoToEntity(bookDto)));
	}

	/**
	 * @description : Gets Book by using it's ID
	 * @param bookId : Takes bookId as parameter
	 * @return BookDto : returns a BookDto
	 * @throws exception : throws BookNotFoundException if Book not found in database
	 * */
	@Override
	public BookDto getBookById(Long bookId) {

		logger.info("Fetching Book with ID " + bookId);
		Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new BookNotFoundException("Book not found with ID : " + bookId));

		return entityToDto(book);
	}

	/**
	 * @description : Updates Book by using it's ID
	 * @param bookId, BookDto : Takes bookId and BookDto as parameters
	 * @return BookDto : returns a BookDto
	 * @throws exception : throws BookNotFoundException if Book not found in database
	 * */
	@Override
	public BookDto updateBookById(Long bookId, BookDto bookDto) {

		Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new BookNotFoundException("Book not found with ID : " + bookId));

		book.setBookId(bookDto.getBookId());
		book.setTitle(bookDto.getTitle());
		book.setAuthor(bookDto.getAuthor());
		book.setCategory(bookDto.getCategory());
		book.setPrice(bookDto.getPrice());

		return entityToDto(bookRepository.save(book));
	}

	/**
	 * @description : deletes Book by using it's ID
	 * @param bookId : Takes bookId as parameter
	 * @throws exception : throws BookNotFoundException if Book not found in database
	 * */
	@Override
	public void deleteBookById(Long bookId) {

		logger.info("Deleting Book with ID " + bookId);

		Book book = bookRepository.findById(bookId)
				.orElseThrow(() -> new BookNotFoundException("Book not found with ID : " + bookId));

		bookRepository.delete(book);

		logger.info("Book Deleted");

	}

	/**
	 * @description : Converts Book entity to Book DTO
	 * @param Book : Takes Book as parameter
	 * @return BookDto : returns a BookDto
	 * */
	private static BookDto entityToDto(Book book) {

		return new ModelMapper().map(book, BookDto.class);
	}

	/**
	 * @description : Converts Book DTO to Book entity
	 * @param BookDto : Takes BookDto as parameter
	 * @return BookDto : returns a BookDto
	 * */
	private static Book dtoToEntity(BookDto bookDto) {

		return new ModelMapper().map(bookDto, Book.class);
	}

}
