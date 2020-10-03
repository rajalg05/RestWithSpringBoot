package com.example.rest.springboot.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.rest.springboot.exception.ExceptionResponse;
import com.example.rest.springboot.exception.UnsupportedMathOperationException;

@RestController
@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest req) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(), 
				ex.getMessage(), 
				req.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR); 
	}

	@ExceptionHandler(UnsupportedMathOperationException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestException(Exception ex, WebRequest req) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(
				new Date(), 
				ex.getMessage(), 
				req.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST); 
	}
	
}
