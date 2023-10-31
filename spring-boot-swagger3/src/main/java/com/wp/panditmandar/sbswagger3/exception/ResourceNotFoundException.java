package com.wp.panditmandar.sbswagger3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends AppException {

	private static final long serialVersionUID = 6163953329128056766L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
