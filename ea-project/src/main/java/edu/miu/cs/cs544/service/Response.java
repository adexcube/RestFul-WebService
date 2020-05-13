package edu.miu.cs.cs544.service;

import java.util.List;

import org.springframework.http.HttpStatus;

public class Response {
	private HttpStatus status_code;
	private int status_cod;
	private String message;
	private Object data;

	public Response(HttpStatus status_code, String message, Object data) {
		this.status_code = status_code;
		this.message = message;
		this.data = data;
	}
	public Response(int status_code, String message, Object data) {
		this.status_cod = status_code;
		this.message = message;
		this.data = data;
	}
	public Response(HttpStatus status_code, String message) {
		this.status_code = status_code;
		this.message = message;
	}
	public Response(int status_code, String message) {
		this.status_cod = status_code;
		this.message = message;
	}

	public HttpStatus getStatus_code() {
		return status_code;
	}

	public void setStatus_code(HttpStatus status_code) {
		this.status_code = status_code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
