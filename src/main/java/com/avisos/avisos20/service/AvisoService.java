package com.avisos.avisos20.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avisos.avisos20.model.Aviso;
import com.avisos.avisos20.repository.IAvisoRepository;

@Service
public class AvisoService {
	
	@Autowired
	private IAvisoRepository repository;
	
	public List<Aviso> findAll(){
		return repository.findAll();
	}
	
	public Optional<Aviso> findById(Long id){
		return repository.findById(id);
	}
	
	public <S extends Aviso> S save(S aviso) {
		return repository.save(aviso);
	}

}
