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
import com.avisos.avisos20.model.Usuario;
import com.avisos.avisos20.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService service;

	@GetMapping
	public List<Usuario> buscarUsuarios() {
		return service.findAll();
	}

	@GetMapping("/{id}")
	public Optional<Usuario> buscarUsuarioPorId(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario) {
		try {
			return ResponseEntity.created(new URI("/usuarios/" + usuario.getId())).body(service.save(usuario));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@PutMapping
	public ResponseEntity<Usuario> editarUsuario(@RequestBody Usuario usuario) throws NotFoundIdException {
		if(usuario.getId() == null  || service.findById(usuario.getId()).isEmpty()) {
			throw new NotFoundIdException();
		} else {
			try {
				return new ResponseEntity<Usuario>(service.save(usuario), HttpStatus.CREATED);
			}catch (Exception e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Optional<Usuario>> deletarUsuario(@PathVariable Long id) throws NotFoundIdException{
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
