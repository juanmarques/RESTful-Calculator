package com.jm.calculator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.NoArgsConstructor;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Please enter a valid input")
@NoArgsConstructor
public class BadRequestException extends NumberFormatException {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

}