package com.treinamento.coursespringbot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamento.coursespringbot.entities.User;
import com.treinamento.coursespringbot.repositories.UserRepository;


//Classe de service
@Service
public class UserService {
	
	//ele faz uma injeção de dependência de forma transparente
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(Long id) {
		//retorn o obj do tipo User.
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

}
