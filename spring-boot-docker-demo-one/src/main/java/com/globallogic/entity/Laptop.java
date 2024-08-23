package com.globallogic.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Document(collection = "laptop")
@Data
public class Laptop {
	
	@MongoId
	private Integer id;
	private String name;

}
