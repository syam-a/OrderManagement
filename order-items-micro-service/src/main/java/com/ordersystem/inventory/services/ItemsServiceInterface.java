package com.ordersystem.inventory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.ordersystem.inventory.entity.OrderItem;

public interface ItemsServiceInterface {

	public List<OrderItem> getAllItems();
	public Optional<OrderItem> getItemByCode(Long code);	
	public List<OrderItem> getItemsByOrderCode(Long code);
	public OrderItem createItem(OrderItem item);
	public void removeItem(Long code);
}
