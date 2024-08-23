package com.globallogic.book.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.globallogic.book.entity.Book;

@Repository
public interface BookRepository extends MongoRepository<Book, Long> {

}
