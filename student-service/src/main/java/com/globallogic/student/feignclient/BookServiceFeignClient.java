package com.globallogic.student.feignclient;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.globallogic.student.dto.BookDto;

@FeignClient(name = "book", url = "http://localhost:8086/api/v1/books")
public interface BookServiceFeignClient {

	@GetMapping
	ResponseEntity<List<BookDto>> fetchAllBooks();

	@PostMapping
	ResponseEntity<BookDto> addBook(@RequestBody BookDto bookDto);

}
