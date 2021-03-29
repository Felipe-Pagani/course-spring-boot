package com.treinamento.coursespringbot.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamento.coursespringbot.entities.User;

//Classe orientada por um Controlador Rest.
@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User user = new User(2L, "Matheus Silva", "MatheusSilva@gmail.com", "(11) 2331-5697", "324");
		return ResponseEntity.ok().body(user);
	}
	
	
	
	
}
