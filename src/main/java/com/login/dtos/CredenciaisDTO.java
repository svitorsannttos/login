package com.login.dtos;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CredenciaisDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String email;
	private String senha;
	
}
