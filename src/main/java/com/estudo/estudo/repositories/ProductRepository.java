package com.estudo.estudo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.estudo.estudo.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
