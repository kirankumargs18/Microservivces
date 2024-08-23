package com.globallogic.exception;

public class UserNameAlreadyTakenException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public UserNameAlreadyTakenException() {
		super();
	}

	public UserNameAlreadyTakenException(String message) {
		super();
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMessage() {
		return message;
	}

}
