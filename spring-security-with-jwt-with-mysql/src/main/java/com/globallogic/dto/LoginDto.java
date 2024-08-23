package com.globallogic.dto;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;

@Api(value = "Login Model Information")
public class LoginDto {

	@ApiModelProperty(value = "username or email of user")
	private String usernameOrEmail;
	
	@ApiModelProperty(value = "password for user")
	private String password;

	public String getUsernameOrEmail() {
		return usernameOrEmail;
	}

	public void setUsernameOrEmail(String usernameOrEmail) {
		this.usernameOrEmail = usernameOrEmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
