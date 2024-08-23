package com.globallogic.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmailAlreadyExistsInDatabaseException.class)
	public ResponseEntity<ErrorResponse> handleEmailAlreadyExistsInDatabaseException(
			EmailAlreadyExistsInDatabaseException exception, WebRequest webRequest) {

		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setTimestamp(new Date());
		errorResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setPath(webRequest.getDescription(false));

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserNameAlreadyTakenException.class)
	public ResponseEntity<ErrorResponse> handlesUserNameAlreadyTakenException(UserNameAlreadyTakenException exception,
			WebRequest webRequest) {

		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setTimestamp(new Date());
		errorResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setPath(webRequest.getDescription(false));

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handlesException(Exception exception, WebRequest webRequest) {

		ErrorResponse errorResponse = new ErrorResponse();

		errorResponse.setTimestamp(new Date());
		errorResponse.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
		errorResponse.setMessage(exception.getMessage());
		errorResponse.setPath(webRequest.getDescription(false));

		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
