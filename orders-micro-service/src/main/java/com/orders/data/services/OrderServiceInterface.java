package com.orders.data.services;

import java.util.List;
import java.util.Optional;

import com.orders.data.entity.Order;

public interface OrderServiceInterface {

	public List<Order> getAllOrders();
	public Optional<Order> getOrderByCode(Long code);
	public Order createOrder(Order item);
	public void removeOrder(Long code);
}
