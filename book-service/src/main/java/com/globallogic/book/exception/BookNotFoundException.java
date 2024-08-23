package com.globallogic.book.exception;

public class BookNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private String message;

	public BookNotFoundException() {
		super();
	}

	public BookNotFoundException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
