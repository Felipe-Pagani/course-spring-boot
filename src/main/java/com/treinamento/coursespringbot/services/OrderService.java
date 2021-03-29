package com.treinamento.coursespringbot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.treinamento.coursespringbot.entities.Order;
import com.treinamento.coursespringbot.repositories.OrderRepository;


//Classe de service
@Service
public class OrderService {
	
	//ele faz uma injeção de dependência de forma transparente
	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll(){
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		//retorn o obj do tipo User.
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}

}
