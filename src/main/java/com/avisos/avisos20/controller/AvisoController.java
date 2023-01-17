package com.avisos.avisos20.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avisos.avisos20.exception.NotFoundIdException;
import com.avisos.avisos20.model.Aviso;
import com.avisos.avisos20.service.AvisoService;

@RestController
@RequestMapping("/avisos")
public class AvisoController {
	
	@Autowired
	private AvisoService service;
	
	@GetMapping
	public List<Aviso> buscarTodosAvisos(){
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Aviso> buscarPorId(@PathVariable("id") Long id){
		return service.findById(id);
	}
	
	@PostMapping
	public ResponseEntity<Aviso> salvarAviso(@RequestBody Aviso aviso) {
//		return ResponseEntity.ok().body(service.save(aviso));
		try {
			service.save(aviso);
			return ResponseEntity.created(new URI("/avisos/" + aviso.getId())).body(aviso);		
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Aviso> editarAviso(@RequestBody Aviso aviso) throws NotFoundIdException {
		if(service.findById(aviso.getId()).isPresent() || aviso.getId() != null ) {
			service.save(aviso);
			return new ResponseEntity<Aviso>(aviso, HttpStatus.CREATED);
		}else {
			throw new NotFoundIdException();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Aviso> deletarAviso(@PathVariable Long id) throws NotFoundIdException{
		if(id == null  || service.findById(id).isEmpty()) {
			throw new NotFoundIdException();
		} else {
			try {
				service.deleteById(id);
				return new ResponseEntity<>( HttpStatus.ACCEPTED);				
			} catch (Exception e) {				
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		}
	}
}
	


