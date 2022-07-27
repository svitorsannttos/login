package com.login.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.login.dtos.UsuarioDTO;
import com.login.models.EnderecoModel;
import com.login.models.UsuarioModel;
import com.login.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private PerfilService perfilService;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public UsuarioModel find(Long id) {
		Optional<UsuarioModel> usuario = repo.findById(id);
		return usuario.orElseThrow(() -> new ObjectNotFoundException(
				"Usuario não encontrado! Id: " + id + ", Tipo: " +  UsuarioModel.class.getName(), null));
	}
	
	@Transactional
	public UsuarioModel insert(UsuarioDTO obj) {
		UsuarioModel newUser = fromDTO(obj);
		newUser.getPerfis().add(perfilService.find(1));
		return repo.save(newUser);
	}
	
	private UsuarioModel fromDTO(UsuarioDTO obj) {
		EnderecoModel end = new EnderecoModel(obj.getCep(), obj.getLogradouro(), obj.getBairro(), obj.getEstado(), obj.getCidade(), obj.getNumero(), obj.getComplemento());
		return new UsuarioModel(obj.getNome(), obj.getSobrenome(), obj.getTipoPessoa(), obj.getEmail(), obj.getDataNascimento(),
				obj.getCpfCnpj(), obj.getCelular(), obj.getTelefone(), pe.encode(obj.getSenha()), obj.getImageUrl(), end);
	}
}
