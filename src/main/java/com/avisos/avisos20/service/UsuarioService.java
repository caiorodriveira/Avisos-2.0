package com.avisos.avisos20.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisos.avisos20.model.Usuario;
import com.avisos.avisos20.repository.IUsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private IUsuarioRepository repository;
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Optional<Usuario> findById(Long id){
		return repository.findById(id);
	}
	
	public <S extends Usuario> S save(S usuario) {
		repository.save(usuario);
		return usuario;
	}
	
	public void deleteById(Long id) {
		repository.deleteById(id);
	}
 	
	

}
