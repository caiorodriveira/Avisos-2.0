package com.avisos.avisos20.exception;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ExceptionDefault {
	
	private OffsetDateTime timstamp;
	private Integer status;
	private String message;
	
	//public ExceptionDefault() {
	//	super();
	//	this.timstamp = OffsetDateTime.now();
	//	this.status = status;
	//	this.error = error;
	//}
	
	
	
	
	
}
