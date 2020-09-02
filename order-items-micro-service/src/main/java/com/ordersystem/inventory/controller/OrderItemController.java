package com.ordersystem.inventory.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ordersystem.inventory.entity.OrderItem;
import com.ordersystem.inventory.services.ItemsServiceInterface;

@RestController
public class OrderItemController {

	@Autowired
	private ItemsServiceInterface itemsServiceInterface;
	
	 @GetMapping("/")
	  public String orderHello(){   
			  
	    
	    return "Hello";
	  }
	 
	 @GetMapping("/products")
	  public List<OrderItem> retrieveOrderItems(){
	    
		 List<OrderItem> items =  itemsServiceInterface.getAllItems();	  
	    
	    return items;
	  }
	 
	 @GetMapping("/product/code/{code}")
	  public OrderItem retrieveOrderItem(@PathVariable String code){
	    
		Optional<OrderItem> item =  itemsServiceInterface.getItemByCode(Long.valueOf(code));	
		OrderItem theItem = null;
		 if(!item.isPresent()){  // check for value is present or not  
			 theItem=item.get();			 
	     }else {
	    	//  TODO : generate exception "Item Not Found"
	    	 throw new RuntimeException("Item "+code+" Not Found!");
	     }
		 
	    return theItem;
	  }
	 @GetMapping("/product/order/code/{code}")
	  public List<OrderItem> retrieveOrderItemsByOrderCode(@PathVariable String code){
	    
		List<OrderItem> items =  itemsServiceInterface.getItemsByOrderCode(Long.valueOf(code));	
		
		 if(items.isEmpty()){  // check for value is present or not  
			    	
	    	 throw new RuntimeException("Items for Order Code "+code+" Not Found!");
	     }
		 
	    return items;
	  }
	 
	 @PostMapping("/product/new")
	  public OrderItem createOrderItem(@RequestBody OrderItem postItem){
	    
		 OrderItem item = itemsServiceInterface.createItem(postItem);			 
		 
	    return item;
	  }
	 
	 @PostMapping("/product/delete/{code}")
	  public void deleteOrderItem(@PathVariable String code){
	    
		itemsServiceInterface.removeItem(Long.valueOf(code));			 
		
	  }
	
}
