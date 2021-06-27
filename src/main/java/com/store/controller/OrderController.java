package com.store.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.model.CustomerOrderInfo;
import com.store.model.OrderInfoModel;
import com.store.service.OrderService;

@RestController
@CrossOrigin
public class OrderController {

	private OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	
	@PostMapping("/make-order")
	public ResponseEntity<Void> makeOrder(@RequestBody OrderInfoModel orderDetails){
		orderService.addOrder(orderDetails);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/customer-orders/{customerId}")
	public ResponseEntity<List<CustomerOrderInfo>> getCustomerOrders(@PathVariable int customerId){
		return new ResponseEntity<>(orderService.getCustomerOrders(customerId),HttpStatus.OK);
	}
	
}
