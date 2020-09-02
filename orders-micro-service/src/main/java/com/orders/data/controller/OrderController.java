package com.orders.data.controller;

import java.text.Collator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orders.data.entity.Order;
import com.orders.data.entity.OrderItem;
import com.orders.data.services.OrderServiceInterface;

@RestController
public class OrderController {

	@Autowired
	private OrderServiceInterface itemsServiceInterface;

	@Autowired
	ItemsFeginClient itemsFegionClient;

	@GetMapping("/")
	public String orderHello() {
		return itemsFegionClient.orderHello();
		//return "Hello Order";
	}

	@GetMapping("/order")
	public List<Order> retrieveOrderItems() {
		
		List<Order> orders = itemsServiceInterface.getAllOrders();				
		
		  List<OrderItem> items = itemsFegionClient.getItems();
		  
		  orders.forEach(o ->{ 
			  	 o.setItems(items.stream().filter(i->i.getProductCode().equals(o.getOrderCode())).collect(Collectors.toList()));
			  	 o.setTotal(0);
			  });		 

		return orders;
	}

	@GetMapping("/order/{code}")
	public Order retrieveOrderItem(@PathVariable String code) {

		Optional<Order> order = itemsServiceInterface.getOrderByCode(Long.valueOf(code));
		Order theOrder = null;
		if (order.isPresent()) { // check for value is present or not
			theOrder = order.get();
			List<OrderItem> items = itemsFegionClient.getOrderedItems(Long.valueOf(code));
			  
			theOrder.setItems(items);
			theOrder.setTotal(0f);
			
		} else {
			// TODO : generate exception "Order Not Found"
			throw new RuntimeException("Order " + code + " Not Found!");
		}

		return theOrder;
	}

	@PostMapping("/order/new")
	public Order createOrder(@RequestBody Order postOrder) {

		Order newOrder = itemsServiceInterface.createOrder(postOrder);
		
		  List<OrderItem> items = itemsFegionClient.getItems();
		  newOrder.setItems(items);
		  newOrder.setTotal(0);
		 
		return newOrder;
	}

	@PostMapping("/order/delete/{code}")
	public void deleteOrder(@PathVariable String code) {

		itemsServiceInterface.removeOrder(Long.valueOf(code));

	}

}
