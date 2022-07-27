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

import com.login.models.PerfilModel;
import com.login.services.PerfilService;

@RestController
@RequestMapping(value = "/perfil")
public class PerfilResource {

	@Autowired
	private PerfilService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<PerfilModel> find(@PathVariable Integer id){
		return ResponseEntity.ok().body(service.find(id));
	}
	
	@PostMapping
	public ResponseEntity<Void> insert(@Valid @RequestBody PerfilModel obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
