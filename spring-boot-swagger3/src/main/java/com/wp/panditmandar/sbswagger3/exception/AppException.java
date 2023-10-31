package com.wp.panditmandar.sbswagger3.exception;

/**
 * Application Level Root Exception
 * 
 */
public class AppException extends RuntimeException {

	private static final long serialVersionUID = 1037181232607198710L;

	public AppException() {
		super();
	}

	public AppException(String message) {
		super(message);
	}

	public AppException(String message, Throwable cause) {
		super(message, cause);
	}
}
