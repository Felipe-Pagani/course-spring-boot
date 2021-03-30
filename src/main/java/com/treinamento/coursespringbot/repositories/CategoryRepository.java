package com.treinamento.coursespringbot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.treinamento.coursespringbot.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
