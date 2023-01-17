package com.avisos.avisos20.exception;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;


@ControllerAdvice
public class Advice {
    
    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<ExceptionDefault> tipoValorErrado() {
    	 int status = HttpStatus.BAD_REQUEST.value();
    	 String message = "Valor inválido"; 
        ExceptionDefault ed = new ExceptionDefault(OffsetDateTime.now(), status, message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ed);
    }
    
    @ExceptionHandler(NotFoundIdException.class)
    public ResponseEntity<ExceptionDefault> idNaoEncontrado(){
    	int status = HttpStatus.BAD_REQUEST.value();
   	 	String message = "Id não encontrado"; 
    	ExceptionDefault ed = new ExceptionDefault(OffsetDateTime.now(), status, message);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ed);
    }

    
}
