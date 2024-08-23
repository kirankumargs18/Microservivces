/**
 * @author kiran
 * @createdDate 22/11/2022
 * */
package com.globallogic.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "books")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	
	@MongoId
	private Long bookId;
	private String title;
	private String author;
	private String category;
	private Double price;

}
