package com.avisos.avisos20.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avisos.avisos20.exception.NotFoundException;
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
	
	@PutMapping("/put")
	public Object editarAviso(@RequestBody Aviso aviso) throws NotFoundException {
		if(service.findById(aviso.getId()).isPresent()) {
			service.save(aviso);
			return new ResponseEntity<Aviso>(aviso, HttpStatus.CREATED);
		}else {
			throw new NotFoundException();
		}
	}
		
		
		
		
//		if( service.findById(aviso.id).isPresent() ) {
//			try {
//				service.save(aviso);
//				return ResponseEntity.created(new URI("/avisos/" + aviso.getId())).body(aviso);		
//			} catch (Exception e) {
//				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//			}
//		}else {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//		}
		
//		try {
//			service.save(aviso);
//			return ResponseEntity.created(new URI("/avisos/" + aviso.getId())).body(aviso);		
//		} catch (Exception e) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//		}
}
	


