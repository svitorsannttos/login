package com.login.dtos.validators;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import com.login.dtos.UsuarioDTO;

public class UsuarioGroupSequenceProvider implements DefaultGroupSequenceProvider<UsuarioDTO>{
	
	@Override
	public List<Class<?>> getValidationGroups(UsuarioDTO usuario){
		List<Class<?>> groups = new ArrayList<>();
		groups.add(UsuarioDTO.class);
		
		if(isPessoaSelecionada(usuario)) {
			groups.add(usuario.getTipoPessoa().getGroup());
		}
		
		return groups;
	}
	
	protected boolean isPessoaSelecionada(UsuarioDTO usuario) {
		return usuario != null && usuario.getTipoPessoa() != null;
	}

}
