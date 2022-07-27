package com.login.services;

import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.login.models.PerfilModel;
import com.login.repositories.PerfilRepository;

@Service
public class PerfilService {

	@Autowired
	private PerfilRepository repo;
	
	public PerfilModel find(Integer id) {
		Optional<PerfilModel> perfil = repo.findById(id);
		return perfil.orElseThrow(() -> new ObjectNotFoundException(
				"Perfil não encontrado! Id: " + id + ", Tipo: " +  PerfilModel.class.getName(), null));
	}
	
	@Transactional
	public PerfilModel insert(PerfilModel obj) {
		return repo.save(obj);
	}
}
