package com.estudo.estudo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.estudo.estudo.entities.OrderItem;
import com.estudo.estudo.entities.pk.OrderItemPK;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

}
