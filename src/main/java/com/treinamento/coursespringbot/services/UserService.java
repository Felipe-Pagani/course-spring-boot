package com.treinamento.coursespringbot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.treinamento.coursespringbot.entities.User;
import com.treinamento.coursespringbot.exceptions.DataBaseException;
import com.treinamento.coursespringbot.exceptions.ResourceNotFoundException;
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
		//return obj.get();
		//Depois do tratamento de erro
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
		
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException	e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}		
		
	}
	public User update(Long id, User obj) {
		User entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}
	
	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		entity.setPassword(obj.getPassword());
		
	}

}
