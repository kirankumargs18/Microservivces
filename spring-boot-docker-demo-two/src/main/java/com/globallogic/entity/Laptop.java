package com.globallogic.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "laptops")
@Getter
@Setter
public class Laptop {

	@MongoId
	private Integer id;
	private String name;

}
