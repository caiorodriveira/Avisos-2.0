package com.avisos.avisos20.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_user")
public class Usuario {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private Long id;
	@Column(nullable = false, length = 20)
	private String usuario;
	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String password;
	
}
