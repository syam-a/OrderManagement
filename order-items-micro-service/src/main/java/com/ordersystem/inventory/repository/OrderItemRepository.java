package com.ordersystem.inventory.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.ordersystem.inventory.entity.OrderItem;


public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	

	
}
