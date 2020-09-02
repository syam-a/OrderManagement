package com.orders.data.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orders.data.entity.Order;
import com.orders.data.repository.OrderRepository;

@Service
public class OrderServices implements OrderServiceInterface {

	@Autowired
	OrderRepository orderRepository;

	
	
	@Transactional
	@Override	
	public List<Order> getAllOrders() {
		List<Order> orders = orderRepository.findAll();
		
		return orders;
	}

	@Transactional
	@Override	
	public Optional<Order> getOrderByCode(Long code) {
		Optional<Order> item = orderRepository.findById(code.longValue());
		return item;
	}

	@Transactional
	@Override
	public Order createOrder(Order order) {
		Order newOrder = orderRepository.save(order);
		
		return newOrder;
	}

	@Transactional
	@Override
	public void removeOrder(Long code) {
		orderRepository.deleteById(code);		
	}

}
