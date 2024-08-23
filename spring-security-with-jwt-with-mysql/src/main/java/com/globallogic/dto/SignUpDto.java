package com.globallogic.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Signup Model Information")
public class SignUpDto {

	@NotBlank(message = "username required")
	@ApiModelProperty(value = "username for User")
	private String username;
	
	@Email
	@ApiModelProperty(value = "email for User")
	private String email;
	
	
	@NotBlank
	@ApiModelProperty(value = "password for the user")
	private String password;
	
	@NotBlank
	@ApiModelProperty(value = "role of the user")
	private String role;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
