/**
 * @author kiran
 * @createdDate 22/11/2022
 * */
package com.globallogic.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class ErrorResponse {
	
	private Date timestamp;
	private HttpStatus httpStatus;
	private String message;
	private String path;
	
}
