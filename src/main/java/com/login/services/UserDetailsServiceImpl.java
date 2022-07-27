package com.login.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.login.models.UsuarioModel;
import com.login.repositories.UsuarioRepository;
import com.login.security.UserSS;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
    private UsuarioRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsuarioModel user = repo.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com e-mail: " + email));
        return new UserSS(user.getId(), user.getEmail(), user.getSenha(), user.getPerfis());
    }
    
}
