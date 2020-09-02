package com.orders.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class OrderMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderMicroServiceApplication.class, args);
	}

}
