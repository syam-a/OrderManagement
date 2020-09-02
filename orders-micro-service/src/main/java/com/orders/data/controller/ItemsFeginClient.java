package com.orders.data.controller;



import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;




import com.orders.data.entity.OrderItem;


@FeignClient(name = "order-items-service")
public interface ItemsFeginClient {
	
        
		 @GetMapping("/products")
		 List<OrderItem> getItems();
		 
		 @GetMapping("/")
		 String orderHello();
		 
		 @GetMapping("/product/order/code/{code}")
		 List<OrderItem> getOrderedItems(Long code);
		
}
