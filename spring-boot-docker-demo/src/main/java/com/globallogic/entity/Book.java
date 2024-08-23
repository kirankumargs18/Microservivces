package com.globallogic.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Document(collection = "book")
@Data
public class Book {

	@MongoId
	private int id;
	private String name;
	private String authorName;
}
