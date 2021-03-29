package com.treinamento.coursespringbot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.treinamento.coursespringbot.entities.User;

//Spring Data Jpa possui uma implementação padrão
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
