package com.estudo.estudo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.estudo.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
