package com.login.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.group.GroupSequenceProvider;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.login.models.enums.TipoPessoa;
import com.login.models.validators.CnpjGroup;
import com.login.models.validators.CpfGroup;
import com.login.dtos.validators.UsuarioGroupSequenceProvider;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@GroupSequenceProvider(UsuarioGroupSequenceProvider.class)
public class UsuarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String imageUrl;
	
	@NotBlank(message = "Nome é obrigatório!")
	@Size(min = 2, max = 20, message = "O nome deve conter de 2 a 20 caracteres!")
	private String nome;
	
	@NotBlank(message = "Sobrenome é obrigatório!")
	@Size(min = 2, max = 20, message = "O sobrenome deve conter de 2 a 20 caracteres!")
	private String sobrenome;
	
	@NotNull(message = "Tipo de pessoa é obrigatório!")
	private TipoPessoa tipoPessoa;
	
	@NotBlank(message = "CPF/CNPJ é obrigatório!")
	@CPF(groups = CpfGroup.class, message = "CPF inválido!")
	@CNPJ(groups = CnpjGroup.class, message = "CNPJ inválido")
	@Size(max = 14)
	private String cpfCnpj;
	
	@NotNull(message = "Data de nascimento é obrigatório!")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	@NotBlank(message = "E-mail é obrigatório!")
	@Email(regexp = ".+[@].+[\\.].+", message = "E-mail inválido!")
	@Size(max = 50)
	private String email;
	
	@Size(min = 5, message = "A senha precisa conter mais que 5 caracteres!")
	private String senha;
	
	@Size(min = 11, max = 11, message = "O número do celular deve conter 11 digitos!")
	private String celular;
	
	@Size(min = 11, max = 11, message = "O número do telefone deve conter 10 digitos!")
	private String telefone;
	
	@NotBlank(message = "Preenchimento obrigatório!")
	@Size(min = 8, max = 8, message = "O CEP deve conter 8 digitos!")
	private String cep;
	
	@NotBlank(message = "Preenchimento obrigatório!")
	@Size(max = 50, message = "O nome do logradouro deve conter no máximo 50 caracteres")
	private String logradouro;
	
	@NotBlank(message = "Preenchimento obrigatório!")
	@Size(max = 20, message = "O nome do bairro deve conter no máximo 20 caracteres")
	private String bairro;
	
	@NotBlank(message = "Preenchimento obrigatório!")
	@Size(max = 8, message = "O numero da localidade deve conter no máximo 8 caracteres")
	private String numero;
	
	@Size(max = 25, message = "O complemento deve conter no máximo 25 caracteres")
	private String complemento;
	
	@NotBlank(message = "Preenchimento obrigatório!")
	@Size(max = 30, message = "O nome da cidade deve conter no máximo 30 caracteres")
	private String cidade;
	
	@NotBlank(message = "Preenchimento obrigatório!")
	@Size(max = 20, message = "O nome do estado deve conter no máximo 20 caracteres")
	private String estado;
	
}
