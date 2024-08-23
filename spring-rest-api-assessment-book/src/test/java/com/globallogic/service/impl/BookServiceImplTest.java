/**
 * @author kiran
 * @createdDate 22/11/2022
 * */
package com.globallogic.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.globallogic.dto.BookDto;
import com.globallogic.entity.Book;
import com.globallogic.repository.BookRepository;
import com.globallogic.service.BookService;

@RunWith(SpringRunner.class)
@SpringBootTest
class BookServiceImplTest {

	@Autowired
	private BookService bookService;

	@MockBean
	private BookRepository bookRepository;

	/**
	 * Tests Get all Books
	 * */
	@Test
	public void testGetAllProducts() {

		List<Book> books = Arrays.asList(new Book(1l, "Java", "author", "category", 2999d),
				new Book(2l, "Python", "author", "category", 2499d));

		List<BookDto> bookDtos = Arrays.asList(new BookDto(1l, "Java", "author", "category", 2999d),
				new BookDto(2l, "Python", "author", "category", 2499d));

		when(bookRepository.findAll()).thenReturn(books);
		assertEquals(2, bookService.getAllBooks().size());
	}

	/**
	 * Tests Get Book By ID
	 * */
	@Test
	public void testGetBookById() {

		Long bookId = 1l;
		Optional<Book> book = Optional.of(new Book(1l, "Java", "author", "category", 2999d));
		
		BookDto bookDto=new BookDto(1l, "Java", "author", "category", 2999d);
		
		when(bookRepository.findById(bookId)).thenReturn(book);

		assertEquals(book.get().getBookId(), bookDto.getBookId());

	}

}
