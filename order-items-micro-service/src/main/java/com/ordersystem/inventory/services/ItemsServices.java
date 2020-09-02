package com.ordersystem.inventory.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersystem.inventory.entity.OrderItem;
import com.ordersystem.inventory.repository.OrderItemRepository;

@Service
public class ItemsServices implements ItemsServiceInterface {

	@Autowired
	OrderItemRepository itemRepository;
	
	
	

	@Transactional
	@Override	
	public List<OrderItem> getAllItems() {
		List<OrderItem> items = itemRepository.findAll();
		return items;
	}

	@Transactional
	@Override	
	public Optional<OrderItem> getItemByCode(Long code) {
		Optional<OrderItem> item = itemRepository.findById(code.longValue());
		return item;
	}

	@Transactional
	@Override
	public OrderItem createItem(OrderItem item) {
		OrderItem newItem = itemRepository.save(item);
		return newItem;
	}

	@Transactional
	@Override
	public void removeItem(Long code) {
		itemRepository.deleteById(code);		
	}

	@Transactional
	@Override
	public List<OrderItem> getItemsByOrderCode(Long code) {
		List<OrderItem> items = itemRepository.findAll();
		if(!items.isEmpty())
			items = itemRepository.findAll().stream().filter(i->i.getProductCode().equals(code)).collect(Collectors.toList());
		return items;
	}

}
