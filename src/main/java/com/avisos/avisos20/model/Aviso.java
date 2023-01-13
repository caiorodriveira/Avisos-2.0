package com.avisos.avisos20.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_avisos")
@PrimaryKeyJoinColumn(name = "usuario_id")
public class Aviso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_aviso")
	public Long id;
	
	@Column(name = "ds_titulo", nullable = false)
	public String titulo;
	
	@Column(name = "ds_descricao", nullable = false, columnDefinition = "TEXT")
	public String descricao;
	
	@Column(nullable = false)
	public Date data;

	
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	public Usuario usuario;
	
	
	

}
