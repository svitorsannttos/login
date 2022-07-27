package com.login.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.login.dtos.UsuarioDTO;
import com.login.models.UsuarioModel;
import com.login.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioModel> find(@PathVariable Long id){
		return ResponseEntity.ok().body(service.find(id));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioDTO obj) {
		UsuarioModel user = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
