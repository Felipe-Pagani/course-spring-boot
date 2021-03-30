package com.treinamento.coursespringbot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamento.coursespringbot.entities.Category;
import com.treinamento.coursespringbot.repositories.CategoryRepository;


//Classe de service
@Service
public class CategoryService {
	
	//ele faz uma injeção de dependência de forma transparente
	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		//retorn o obj do tipo Category.
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}

}
