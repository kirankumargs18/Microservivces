/**
 * @author kiran
 * @createdDate 22/11/2022
 * */
package com.globallogic.exception;

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

}
