package com.treinamento.coursespringbot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamento.coursespringbot.entities.Product;
import com.treinamento.coursespringbot.repositories.ProductRepository;

//Classe de service
@Service
public class ProductService {

	// ele faz uma injeção de dependência de forma transparente
	@Autowired
	private ProductRepository repository;

	public List<Product> findAll() {
		return repository.findAll();
	}

	public Product findById(Long id) {
		// retorn o obj do tipo Product.
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}

}
