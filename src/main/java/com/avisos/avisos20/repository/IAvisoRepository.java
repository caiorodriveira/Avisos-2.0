package com.avisos.avisos20.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avisos.avisos20.model.Aviso;

public interface IAvisoRepository extends JpaRepository<Aviso, Long>{

}
