package com.login.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.login.models.enums.TipoPessoa;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(schema = "cadastros_gerais", name = "tb_usuario")
public class UsuarioModel implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String sobrenome;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_pessoa", nullable = false)
	private TipoPessoa tipoPessoa;
	
	@Column(unique = true, nullable = false)
	private String email;
	
	@Column(name = "data_de_nascimento", nullable = false)
	private LocalDate dataNascimento;
	
	@Column(unique = true, name = "cpf_cnpj", nullable = false)
	private String cpfCnpj;
	
	@Column(unique = true)
	private String celular;
	
	@Column(unique = true)
	private String telefone;
	
	@Column(nullable = false)
	private String senha;
	
	@Embedded
	@NotNull
	private EnderecoModel endereco;
	
	private String imageUrl;
	
	@Column(name = "data_de_cadastro", nullable = false)
	private LocalDateTime dataCadastro;
	
	@Column(name = "data_de_atualizacao", nullable = false)
	private LocalDateTime dataAtualizacao;
	
	@ManyToMany()
	@JoinTable(schema = "cadastros_gerais", name = "tb_usuario_perfil",
			joinColumns = @JoinColumn(name = "id_usuario", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "id_perfil", nullable = false))
	private Set<PerfilModel> perfis = new HashSet<>();
	
	public UsuarioModel(String nome, String sobrenome, TipoPessoa tipoPessoa, String email, LocalDate dataNascimento,
			String cpfCnpj, String celular, String telefone, String senha, String imageUrl,
			EnderecoModel endereco) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.tipoPessoa = tipoPessoa;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.cpfCnpj = cpfCnpj;
		this.celular = celular;
		this.telefone = telefone;
		this.senha = senha;
		this.imageUrl = imageUrl;
		this.endereco = endereco;
		this.dataCadastro = LocalDateTime.now();
		this.dataAtualizacao =LocalDateTime.now();
	}

}
