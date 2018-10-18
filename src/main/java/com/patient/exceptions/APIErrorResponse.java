package com.patient.exceptions;

import org.springframework.http.HttpStatus;

public class APIErrorResponse {
	private HttpStatus status;
	private String error_code;
	private String message;
	private String detail;

	
	public APIErrorResponse(HttpStatus status, String error_code, String message, String detail) {
		this.status = status;
		this.error_code = error_code;
		this.message = message;
		this.detail = detail;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getError_code() {
		return error_code;
	}

	public void setError_code(String error_code) {
		this.error_code = error_code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

}
