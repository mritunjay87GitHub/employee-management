package com.mks.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class ResponseHeaderException extends RuntimeException {

	private static final long serialVersionUID = 3519254292038356649L;

	public ResponseHeaderException() {
		super();
	}

	public ResponseHeaderException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ResponseHeaderException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResponseHeaderException(String message) {
		super(message);
	}

	public ResponseHeaderException(Throwable cause) {
		super(cause);
	}

}
