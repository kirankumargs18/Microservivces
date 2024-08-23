package com.globallogic.entity;

import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Data;

@Document(collection = "user")
@Data
public class User {
	
	@MongoId
	private UUID userId=UUID.randomUUID();
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String contactNumber;
	private String password;
	private Role role;
	private Address address;
	
}
