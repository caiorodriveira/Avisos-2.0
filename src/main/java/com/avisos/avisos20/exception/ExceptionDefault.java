package com.avisos.avisos20.exception;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ExceptionDefault {
	
	private OffsetDateTime timstamp;
	private HttpStatus status;
	private String error;
	
	public ExceptionDefault() {
		super();
		this.timstamp = OffsetDateTime.now();
		this.status = status;
		this.error = error;
	}
	
	
	
	
	
}
