package com.orders.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orders.data.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
	

}
