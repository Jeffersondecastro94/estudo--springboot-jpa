package com.estudo.estudo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.estudo.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
