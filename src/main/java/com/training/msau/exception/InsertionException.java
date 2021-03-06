package com.training.msau.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class InsertionException extends RuntimeException{ //This is thrown when foreign keys are violated
	private static final long serialVersionUID = 1L;
	
	public InsertionException() {
		super("Invalid Data For Entry");
	}

	public InsertionException(String message) {
		super(message);
	}

	public InsertionException(Throwable cause) {
		super(cause);
	}

	public InsertionException(String message, Throwable cause) {
		super(message, cause);
	}

	public InsertionException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
