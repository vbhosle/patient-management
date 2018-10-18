package com.patient.exceptions;

import javax.validation.ValidationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler{
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	protected ResponseEntity<APIErrorResponse> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<APIErrorResponse>(new APIErrorResponse(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.toString(), "Invalid data", ex.getMessage()), httpHeaders, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler({ValidationException.class, HttpMediaTypeException.class})
	protected ResponseEntity<APIErrorResponse> handleValidationExceptions(Exception ex){
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		return new ResponseEntity<APIErrorResponse>(new APIErrorResponse(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.toString(), "Invalid data received", ex.getMessage()), httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler({Exception.class})
	protected ResponseEntity<APIErrorResponse> handleAllExceptions(Exception ex){
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		ex.printStackTrace();
		return new ResponseEntity<APIErrorResponse>(new APIErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, HttpStatus.INTERNAL_SERVER_ERROR.toString(), "Some unexpected error occurred", ex.getMessage()), httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
