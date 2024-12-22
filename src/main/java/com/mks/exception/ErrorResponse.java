package com.mks.exception;

import java.io.Serializable;
import java.util.List;

public class ErrorResponse {

	private String message;
	private List<Serializable> details;

	public ErrorResponse(String message, List<Serializable> list) {
		super();
		this.message = message;
		this.details = list;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<Serializable> getDetails() {
		return details;
	}

	public void setDetails(List<Serializable> details) {
		this.details = details;
	}

}
