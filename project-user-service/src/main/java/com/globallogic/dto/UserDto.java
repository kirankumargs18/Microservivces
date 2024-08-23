package com.globallogic.dto;

import com.globallogic.entity.Role;

import lombok.Data;

@Data
public class UserDto {
	
	private String firstName;
	private String lastName;
	private String username;
	private String email;
	private String contactNumber;
	private String password;
	private Role role;
	private AddressDto address;

}
