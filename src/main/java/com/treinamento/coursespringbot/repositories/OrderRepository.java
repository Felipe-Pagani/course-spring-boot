package com.treinamento.coursespringbot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamento.coursespringbot.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
