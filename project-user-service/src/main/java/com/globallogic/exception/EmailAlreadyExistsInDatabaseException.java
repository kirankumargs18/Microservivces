package com.globallogic.exception;

public class EmailAlreadyExistsInDatabaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	private String message;

	public EmailAlreadyExistsInDatabaseException() {
		super();
	}

	public EmailAlreadyExistsInDatabaseException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
