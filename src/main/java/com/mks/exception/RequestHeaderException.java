package com.mks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class RequestHeaderException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3519254292038356649L;

	public RequestHeaderException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequestHeaderException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public RequestHeaderException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public RequestHeaderException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public RequestHeaderException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
