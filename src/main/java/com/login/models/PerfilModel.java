package com.login.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(schema = "cadastros_gerais", name = "tb_perfil")
public class PerfilModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
    @Column(nullable = false, unique = true)
	private String nome;

	@JsonIgnore
	@ManyToMany(mappedBy = "perfis")
	private Set<UsuarioModel> usuarios = new HashSet<>();
	
	public PerfilModel(Integer id) {
		this.id = id;
	}
	
	public PerfilModel(String nome) {
		this.nome = nome;
	}
	
}
