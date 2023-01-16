package com.avisos.avisos20.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;


@ControllerAdvice
public class Advice {
    
    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<ExceptionDefault> tipoValorErrado() {
    	 HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
    	 String error = "Valor inválido";
    	 
    	 
        ExceptionDefault ed = new ExceptionDefault();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ed);
    }
    
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDefault> valorNaoEncontrado(){
        ExceptionDefault ed = new ExceptionDefault();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ed);
    }
    
}
