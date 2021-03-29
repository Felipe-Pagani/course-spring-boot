package com.treinamento.coursespringbot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treinamento.coursespringbot.entities.Order;

//Spring Data Jpa possui uma implementação padrão
@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
