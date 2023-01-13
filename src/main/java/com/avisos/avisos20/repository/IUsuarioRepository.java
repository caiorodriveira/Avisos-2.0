package com.avisos.avisos20.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avisos.avisos20.model.Usuario;


public interface IUsuarioRepository extends JpaRepository <Usuario, Long>{

}
