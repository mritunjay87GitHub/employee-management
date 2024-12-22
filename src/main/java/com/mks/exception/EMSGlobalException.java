package com.mks.exception;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@RestControllerAdvice
@ControllerAdvice
public class EMSGlobalException extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(RequestHeaderException.class)
	public final ResponseEntity<ErrorResponse> missingHeaderException(RequestHeaderException requestHeaderException) {
		ErrorResponse errorResponse = new ErrorResponse(requestHeaderException.getMessage(), Arrays.asList(requestHeaderException.getLocalizedMessage(),requestHeaderException.getCause()));
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResponseHeaderException.class)
	public final ResponseEntity<String> responseHeaderException(ResponseHeaderException responseHeaderException) {
		return new ResponseEntity<String>(responseHeaderException.getMessage(), HttpStatus.EXPECTATION_FAILED);
	}

}
